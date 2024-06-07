package com.example.webservice.repository;

import com.example.webservice.entity.ProductDocument;
import com.example.webservice.entity.ProductDocumentID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDocumentRepository extends JpaRepository<ProductDocument, ProductDocumentID> {
}
