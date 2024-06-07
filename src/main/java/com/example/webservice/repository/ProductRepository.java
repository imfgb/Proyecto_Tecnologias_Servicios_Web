package com.example.webservice.repository;

import com.example.webservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductNumber(String productNumber);

    @Query("SELECT p FROM Product p " +
           "LEFT JOIN FETCH p.sizeUnitMeasure " +
           "LEFT JOIN FETCH p.weightUnitMeasure " +
           "LEFT JOIN FETCH p.productSubcategory " +
           "LEFT JOIN FETCH p.productModel " +
           "WHERE p.productId = :id")
    Optional<Product> findByIdWithJoins(int id);

    @Query("SELECT p FROM Product p " +
           "LEFT JOIN FETCH p.sizeUnitMeasure " +
           "LEFT JOIN FETCH p.weightUnitMeasure " +
           "LEFT JOIN FETCH p.productSubcategory " +
           "LEFT JOIN FETCH p.productModel " +
           "WHERE p.productSubcategory.productSubcategoryId = :subcategoryId")
    List<Product> findByProductSubcategoryId(int subcategoryId);
}
