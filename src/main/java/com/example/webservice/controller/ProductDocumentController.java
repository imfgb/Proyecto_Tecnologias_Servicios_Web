package com.example.webservice.controller;

import com.example.webservice.dto.ProductDocumentDTO;
import com.example.webservice.entity.ProductDocument;
import com.example.webservice.entity.ProductDocumentID;
import com.example.webservice.service.ProductDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-documents")
public class ProductDocumentController {
    private final ProductDocumentService productDocumentService;

    @Autowired
    public ProductDocumentController(ProductDocumentService productDocumentService) {
        this.productDocumentService = productDocumentService;
    }

    @GetMapping
    public List<ProductDocumentDTO> getAllProductDocuments() {
        return productDocumentService.findAll();
    }

    @GetMapping("/{productId}/{documentNode}")
    public ResponseEntity<ProductDocumentDTO> getProductDocumentById(@PathVariable int productId, @PathVariable String documentNode) {
        ProductDocumentID id = new ProductDocumentID(productId, documentNode);
        return productDocumentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductDocumentDTO createProductDocument(@RequestBody ProductDocument productDocument) {
        return productDocumentService.save(productDocument);
    }

    @DeleteMapping("/{productId}/{documentNode}")
    public ResponseEntity<Void> deleteProductDocument(@PathVariable int productId, @PathVariable String documentNode) {
        ProductDocumentID id = new ProductDocumentID(productId, documentNode);
        productDocumentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
