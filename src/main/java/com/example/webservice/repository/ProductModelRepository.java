package com.example.webservice.repository;

import com.example.webservice.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductModelRepository extends JpaRepository<ProductModel, Integer> {
}
