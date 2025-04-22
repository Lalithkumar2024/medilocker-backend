package com.medilocker.service;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.medilocker.entity.Document;
import com.medilocker.entity.Patient;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.DocumentRepository;
import com.medilocker.repository.PatientRepository;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AmazonS3 s3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Value("${cloud.aws.credentials.base-url}")
    private String baseURL;

    public Document upload(MultipartFile file,int patient_id){

        Patient patient = patientRepository.findById(patient_id)
                .orElseThrow(()->new CustomException("Patient","patient_id",patient_id));

        String patientName = patient.getUsers().getName().trim().replaceAll(" ","_");
        String fileName = file.getOriginalFilename();
        String uniqueFileName = patientName + "_" +fileName;
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);

        String fileUrl = baseURL + uniqueFileName;
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            s3.putObject(bucketName, uniqueFileName, file.getInputStream(), metadata);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }

        Document document = new Document();
        document.setFileName(uniqueFileName);
        document.setFileType(fileExtension);
        document.setFileUrl(fileUrl);
        document.setPatient(patient);

        return documentRepository.save(document);
    }

    public Document getDocument(int document_id){
        Optional<Document> document = documentRepository.findById(document_id);
        if (document.isPresent()){
            return document.get();
        }else {
            throw new CustomException("Document","document_id",document_id);
        }
    }

    public List<Document> getAllDocument(){
        return documentRepository.findAll();
    }
    
    public byte[] downloadDocument(String fileName){
    	
    	S3Object s3Object = s3.getObject(bucketName, fileName);
    	S3ObjectInputStream inputStream = s3Object.getObjectContent();
    	try {
			byte[] docs = IOUtils.toByteArray(inputStream);
			return docs;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    	
    	
    }
    
    public String generatePresignedUrl(String fileName, int expirationMinutes) {
        Date expiration = new Date(System.currentTimeMillis() + expirationMinutes * 60 * 1000);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, fileName)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expiration);

        URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

}
