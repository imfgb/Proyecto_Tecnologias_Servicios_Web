package com.example.webservice.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ProductModel", schema = "Production")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductModelID")
    private Integer productModelId;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "productModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;

    // Getters and Setters

    public Integer getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(Integer productModelId) {
        this.productModelId = productModelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
