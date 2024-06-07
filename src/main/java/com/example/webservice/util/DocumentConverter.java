package com.example.webservice.util;

import com.example.webservice.dto.DocumentDTO;
import com.example.webservice.entity.Document;

public class DocumentConverter {

    public static DocumentDTO toDTO(Document document) {
        DocumentDTO dto = new DocumentDTO();
        dto.setDocumentNode(document.getDocumentNode());
        dto.setDocumentLevel(document.getDocumentLevel());
        dto.setTitle(document.getTitle());
        dto.setOwner(document.getOwner());
        dto.setFolderFlag(document.isFolderFlag());
        dto.setFileName(document.getFileName());
        dto.setFileExtension(document.getFileExtension());
        dto.setRevision(document.getRevision());
        dto.setChangeNumber(document.getChangeNumber());
        dto.setStatus(document.getStatus());
        dto.setDocumentSummary(document.getDocumentSummary());
        dto.setDocument(document.getDocument());
        dto.setRowguid(document.getRowguid());
        dto.setModifiedDate(document.getModifiedDate());
        return dto;
    }
}
