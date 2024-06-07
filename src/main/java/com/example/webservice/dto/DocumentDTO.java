package com.example.webservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class DocumentDTO {
    private String documentNode;
    private short documentLevel;
    private String title;
    private int owner;
    private boolean folderFlag;
    private String fileName;
    private String fileExtension;
    private String revision;
    private int changeNumber;
    private byte status;
    private String documentSummary;
    private byte[] document;
    private UUID rowguid;
    private LocalDateTime modifiedDate;

    // Getters and Setters
    public String getDocumentNode() {
        return documentNode;
    }

    public void setDocumentNode(String documentNode) {
        this.documentNode = documentNode;
    }

    public short getDocumentLevel() {
        return documentLevel;
    }

    public void setDocumentLevel(short documentLevel) {
        this.documentLevel = documentLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public boolean isFolderFlag() {
        return folderFlag;
    }

    public void setFolderFlag(boolean folderFlag) {
        this.folderFlag = folderFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public int getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(int changeNumber) {
        this.changeNumber = changeNumber;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getDocumentSummary() {
        return documentSummary;
    }

    public void setDocumentSummary(String documentSummary) {
        this.documentSummary = documentSummary;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public UUID getRowguid() {
        return rowguid;
    }

    public void setRowguid(UUID rowguid) {
        this.rowguid = rowguid;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
