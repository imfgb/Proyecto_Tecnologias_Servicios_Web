package com.example.webservice.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Document", schema = "Production")
public class Document {
    @Id
    @Column(name = "DocumentNode", nullable = false)
    private String documentNode;

    @Column(name = "DocumentLevel", nullable = false)
    private short documentLevel;

    @Column(name = "Title", length = 50)
    private String title;

    @Column(name = "Owner", nullable = false)
    private int owner;

    @Column(name = "FolderFlag", nullable = false)
    private boolean folderFlag;

    @Column(name = "FileName", length = 400)
    private String fileName;

    @Column(name = "FileExtension", length = 8)
    private String fileExtension;

    @Column(name = "Revision", length = 5)
    private String revision;

    @Column(name = "ChangeNumber", nullable = false)
    private int changeNumber;

    @Column(name = "Status", nullable = false)
    private byte status;

    @Column(name = "DocumentSummary", length = Integer.MAX_VALUE)
    private String documentSummary;

    @Column(name = "Document")
    private byte[] document;

    @Column(name = "rowguid", nullable = false, columnDefinition = "uniqueidentifier")
    private UUID rowguid;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductDocument> productDocuments;

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

    public Set<ProductDocument> getProductDocuments() {
        return productDocuments;
    }

    public void setProductDocuments(Set<ProductDocument> productDocuments) {
        this.productDocuments = productDocuments;
    }
}
