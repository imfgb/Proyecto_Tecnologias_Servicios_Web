package com.example.webservice.service;

import com.example.webservice.dto.ProductReviewDTO;
import com.example.webservice.entity.Product;
import com.example.webservice.entity.ProductReview;
import com.example.webservice.repository.ProductReviewRepository;
import com.example.webservice.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductReviewService {
    private final ProductReviewRepository productReviewRepository;
    private final ProductService productService;

    @Autowired
    public ProductReviewService(ProductReviewRepository productReviewRepository, ProductService productService) {
        this.productReviewRepository = productReviewRepository;
        this.productService = productService;
    }

    public List<ProductReview> findAll() {
        return productReviewRepository.findAllWithProducts();
    }

    public Optional<ProductReview> findById(int id) {
        return productReviewRepository.findById(id);
    }

    public ProductReview save(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    public void deleteById(int id) {
        productReviewRepository.deleteById(id);
    }

    public ProductReview update(ProductReview productReview) throws Exception {
        if (!productReviewRepository.existsById(productReview.getProductReviewId())) {
            throw new Exception("ProductReview not found.");
        }
        return productReviewRepository.save(productReview);
    }

    public List<ProductReviewDTO> findAllDTOs() {
        return findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductReviewDTO> findDTOById(int id) {
        return findById(id)
                .map(this::convertToDto);
    }

    public List<ProductReviewDTO> findDTOsByProductId(int productId) {
        return productReviewRepository.findByProduct_ProductId(productId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProductReviewDTO convertToDto(ProductReview productReview) {
        ProductReviewDTO dto = new ProductReviewDTO();
        dto.setProductName(StringUtil.sanitize(productReview.getProduct().getName()));
        dto.setReviewerName(StringUtil.sanitize(productReview.getReviewerName()));
        dto.setReviewDate(productReview.getReviewDate());
        dto.setEmailAddress(StringUtil.sanitize(productReview.getEmailAddress()));
        dto.setRating(productReview.getRating());
        dto.setComments(StringUtil.sanitize(productReview.getComments()));
        dto.setModifiedDate(productReview.getModifiedDate());

        dto.setProductReviewId(productReview.getProductReviewId());
        dto.setProductId(productReview.getProduct().getProductId());
        return dto;
    }

    public ProductReview convertToEntity(ProductReviewDTO dto) throws Exception {
        ProductReview productReview = new ProductReview();
        productReview.setProductReviewId(dto.getProductReviewId());
        Optional<Product> product = productService.findById(dto.getProductId());
        if (!product.isPresent()) {
            throw new Exception("Product not found with ID: " + dto.getProductId());
        }
        productReview.setProduct(product.get());
        productReview.setReviewerName(dto.getReviewerName());
        productReview.setReviewDate(dto.getReviewDate());
        productReview.setEmailAddress(dto.getEmailAddress());
        productReview.setRating(dto.getRating());
        productReview.setComments(dto.getComments());
        productReview.setModifiedDate(dto.getModifiedDate());
        return productReview;
    }
}