package com.example.webservice.repository;

import com.example.webservice.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
    @Query("SELECT pr FROM ProductReview pr JOIN FETCH pr.product WHERE pr.product.productId = :productId")
    List<ProductReview> findByProduct_ProductId(int productId);

    @Query("SELECT pr FROM ProductReview pr JOIN FETCH pr.product")
    List<ProductReview> findAllWithProducts();
}
