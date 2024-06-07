package com.example.webservice.service;

import com.example.webservice.dto.ProductDocumentDTO;
import com.example.webservice.entity.ProductDocument;
import com.example.webservice.entity.ProductDocumentID;
import com.example.webservice.repository.ProductDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDocumentService {
    private final ProductDocumentRepository productDocumentRepository;

    @Autowired
    public ProductDocumentService(ProductDocumentRepository productDocumentRepository) {
        this.productDocumentRepository = productDocumentRepository;
    }

    public List<ProductDocumentDTO> findAll() {
        return productDocumentRepository.findAll().stream()
                .map(this::sanitizeProductDocument)
                .collect(Collectors.toList());
    }

    public Optional<ProductDocumentDTO> findById(ProductDocumentID id) {
        return productDocumentRepository.findById(id)
                .map(this::sanitizeProductDocument);
    }

    public ProductDocumentDTO save(ProductDocument productDocument) {
        ProductDocument savedProductDocument = productDocumentRepository.save(productDocument);
        return sanitizeProductDocument(savedProductDocument);
    }

    public void deleteById(ProductDocumentID id) {
        productDocumentRepository.deleteById(id);
    }

    private ProductDocumentDTO sanitizeProductDocument(ProductDocument productDocument) {
        ProductDocumentDTO dto = new ProductDocumentDTO();
        dto.setProductId(productDocument.getProduct().getProductId());
        dto.setDocumentNode(productDocument.getDocument().getDocumentNode() != null ? productDocument.getDocument().getDocumentNode().trim() : null);
        dto.setModifiedDate(productDocument.getModifiedDate());
        return dto;
    }
}
