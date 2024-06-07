package com.example.webservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ProductSubcategory", schema = "Production")
public class ProductSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductSubcategoryID")
    private Integer productSubcategoryId;

    @Column(name = "ProductCategoryID", nullable = false)
    private String productCategory;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "rowguid", nullable = false, columnDefinition = "uniqueidentifier")
    private UUID rowguid;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "productSubcategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;

    public Integer getProductSubcategoryId() {
        return productSubcategoryId;
    }

    public void setProductSubcategoryId(Integer productSubcategoryId) {
        this.productSubcategoryId = productSubcategoryId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getRowguid() {
        return rowguid;
    }

    public void setRowguid(UUID rowguid) {
        this.rowguid = rowguid;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
