package com.example.webservice.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductDocumentID implements Serializable {
    private int productId;
    private String documentNode;

    public ProductDocumentID() {
    }

    public ProductDocumentID(int productId, String documentNode) {
        this.productId = productId;
        this.documentNode = documentNode;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDocumentNode() {
        return documentNode;
    }

    public void setDocumentNode(String documentNode) {
        this.documentNode = documentNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDocumentID that = (ProductDocumentID) o;
        return Objects.equals(productId, that.productId) && Objects.equals(documentNode, that.documentNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, documentNode);
    }
}
