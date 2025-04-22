package com.medilocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medilocker.entity.Document;
import com.medilocker.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload/{patient_id}")
    public ResponseEntity<Document> upload(@RequestParam("file") MultipartFile file,@PathVariable int patient_id){
        return new ResponseEntity<Document>(documentService.upload(file,patient_id), HttpStatus.OK);
    }

    @GetMapping("/getDocument/{document_id}")
    public Document getDocument(@PathVariable int document_id){
        return documentService.getDocument(document_id);
    }

    @GetMapping("/getAllDocument")
    public List<Document> getAllDocument(){
        return documentService.getAllDocument();
    }
    
    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable String fileName){
      
    	byte[] data = documentService.downloadDocument(fileName);
    	ByteArrayResource resource = new ByteArrayResource(data);
    
        return ResponseEntity.ok()
                .contentLength(data.length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    
    @GetMapping("/share/{fileName}")
    public ResponseEntity<String> shareDocument(@PathVariable String fileName) {
        String preSignedUrl = documentService.generatePresignedUrl(fileName, 10);
        return ResponseEntity.ok(preSignedUrl);
    }

    
  
}
