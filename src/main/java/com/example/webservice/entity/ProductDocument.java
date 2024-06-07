package com.example.webservice.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "ProductDocument", schema = "Production")
public class ProductDocument {
    @EmbeddedId
    private ProductDocumentID id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @ManyToOne
    @MapsId("documentNode")
    @JoinColumn(name = "DocumentNode", nullable = false)
    private Document document;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    public ProductDocumentID getId() {
        return id;
    }

    public void setId(ProductDocumentID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
