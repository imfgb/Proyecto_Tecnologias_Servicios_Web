package com.example.webservice.repository;

import com.example.webservice.entity.ProductSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSubcategoryRepository extends JpaRepository<ProductSubcategory, Integer> {
}
