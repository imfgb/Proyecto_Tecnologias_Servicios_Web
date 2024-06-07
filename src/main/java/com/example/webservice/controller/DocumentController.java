package com.example.webservice.controller;

import com.example.webservice.dto.DocumentDTO;
import com.example.webservice.entity.Document;
import com.example.webservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<DocumentDTO> getAllDocuments() {
        return documentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable String id) {
        return documentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DocumentDTO createDocument(@RequestBody Document document) {
        return documentService.save(document);
    }

    @PutMapping
    public DocumentDTO updateDocument(@RequestBody Document document) {
        return documentService.save(document);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable String id) {
        documentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
