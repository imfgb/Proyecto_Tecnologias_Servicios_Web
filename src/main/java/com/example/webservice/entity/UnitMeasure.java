package com.example.webservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "UnitMeasure", schema = "Production")
public class UnitMeasure {
    @Id
    @Column(name = "UnitMeasureCode", length = 3)
    private String unitMeasureCode;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "sizeUnitMeasure")
    private Set<Product> productsBySize;

    @OneToMany(mappedBy = "weightUnitMeasure")
    private Set<Product> productsByWeight;

    public String getUnitMeasureCode() {
        return unitMeasureCode;
    }

    public void setUnitMeasureCode(String unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Set<Product> getProductsBySize() {
        return productsBySize;
    }

    public void setProductsBySize(Set<Product> productsBySize) {
        this.productsBySize = productsBySize;
    }

    public Set<Product> getProductsByWeight() {
        return productsByWeight;
    }

    public void setProductsByWeight(Set<Product> productsByWeight) {
        this.productsByWeight = productsByWeight;
    }
}
