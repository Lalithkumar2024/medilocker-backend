package com.medilocker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int document_id;

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "patient_id")
    private Patient patient;

    @Column(unique = true)
    private String fileName;
    @Column(unique = true)
    private String fileUrl;
    private String fileType;

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "Document{" +
                "document_id=" + document_id +
                ", patient=" + patient +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
