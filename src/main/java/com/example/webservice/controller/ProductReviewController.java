package com.example.webservice.controller;

import com.example.webservice.dto.ProductReviewDTO;
import com.example.webservice.entity.ProductReview;
import com.example.webservice.service.ProductReviewService;
import com.example.webservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-reviews")
public class ProductReviewController {
    private final ProductReviewService productReviewService;
    private final ProductService productService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService, ProductService productService) {
        this.productReviewService = productReviewService;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductReviewDTO> getAllProductReviews() {
        return productReviewService.findAllDTOs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductReviewDTO> getProductReviewById(@PathVariable int id) {
        Optional<ProductReviewDTO> productReview = productReviewService.findDTOById(id);
        return productReview.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public List<ProductReviewDTO> getProductReviewsByProductId(@PathVariable int productId) {
        return productReviewService.findDTOsByProductId(productId);
    }

    @PostMapping
    public ResponseEntity<?> createProductReview(@RequestBody ProductReviewDTO productReviewDTO) {
        try {
            ProductReview productReview = productReviewService.convertToEntity(productReviewDTO);
            ProductReview savedProductReview = productReviewService.save(productReview);
            return ResponseEntity.ok(productReviewService.convertToDto(savedProductReview));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductReview(@PathVariable int id) {
        productReviewService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductReview(@PathVariable int id, @RequestBody ProductReviewDTO productReviewDTO) {
        try {
            Optional<ProductReview> existingReview = productReviewService.findById(id);
            if (!existingReview.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            ProductReview productReview = productReviewService.convertToEntity(productReviewDTO);
            productReview.setProductReviewId(id);
            ProductReview updatedProductReview = productReviewService.update(productReview);
            return ResponseEntity.ok(productReviewService.convertToDto(updatedProductReview));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}