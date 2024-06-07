package com.example.webservice.controller;

import com.example.webservice.dto.ProductDTO;
import com.example.webservice.entity.Product;
import com.example.webservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.findAllDTOs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
        return productService.findDTOById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/subcategory/{subcategoryId}")
    public List<ProductDTO> getProductsBySubcategoryId(@PathVariable int subcategoryId) {
        return productService.findByProductSubcategoryId(subcategoryId);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            if (productDTO.getRowguid() == null) {
                productDTO.setRowguid(UUID.randomUUID());
            }

            if (productDTO.getModifiedDate() == null) {
                productDTO.setModifiedDate(LocalDateTime.now());
            }

            Product product = productService.convertToEntity(productDTO);
            Product savedProduct = productService.save(product);
            return ResponseEntity.ok(productService.convertToDto(savedProduct));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        try {
            Product product = productService.convertToEntity(productDTO);
            product.setProductId(id);
            Product updatedProduct = productService.update(product);
            return ResponseEntity.ok(productService.convertToDto(updatedProduct));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
