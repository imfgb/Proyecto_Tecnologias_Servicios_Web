package com.example.webservice.service;

import com.example.webservice.dto.DocumentDTO;
import com.example.webservice.entity.Document;
import com.example.webservice.repository.DocumentRepository;
import com.example.webservice.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<DocumentDTO> findAll() {
        return documentRepository.findAll().stream()
                .map(this::sanitizeDocument)
                .collect(Collectors.toList());
    }

    public Optional<DocumentDTO> findById(String id) {
        return documentRepository.findById(id)
                .map(this::sanitizeDocument);
    }

    public DocumentDTO save(Document document) {
        Document savedDocument = documentRepository.save(document);
        return sanitizeDocument(savedDocument);
    }

    public void deleteById(String id) {
        documentRepository.deleteById(id);
    }

    private DocumentDTO sanitizeDocument(Document document) {
        DocumentDTO dto = new DocumentDTO();
        dto.setDocumentNode(document.getDocumentNode() != null ? document.getDocumentNode().trim() : null);
        dto.setTitle(StringUtil.sanitize(document.getTitle()));
        dto.setFileName(StringUtil.sanitize(document.getFileName()));
        dto.setFileExtension(document.getFileExtension());
        dto.setRevision(StringUtil.sanitize(document.getRevision()));
        dto.setChangeNumber(document.getChangeNumber());
        dto.setStatus(document.getStatus());
        dto.setModifiedDate(document.getModifiedDate());
        return dto;
    }
}
