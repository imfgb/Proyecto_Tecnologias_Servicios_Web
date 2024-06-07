package com.example.webservice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Product", schema = "Production")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "ProductNumber", nullable = false, length = 25)
    private String productNumber;

    @Column(name = "MakeFlag", nullable = false)
    private boolean makeFlag;

    @Column(name = "FinishedGoodsFlag", nullable = false)
    private boolean finishedGoodsFlag;

    @Column(name = "Color", length = 15)
    private String color;

    @Column(name = "SafetyStockLevel", nullable = false)
    private short safetyStockLevel;

    @Column(name = "ReorderPoint", nullable = false)
    private int reorderPoint;

    @Column(name = "StandardCost", nullable = false)
    private BigDecimal standardCost;

    @Column(name = "ListPrice", nullable = false)
    private BigDecimal listPrice;

    @Column(name = "Size", length = 5)
    private String size;

    @ManyToOne
    @JoinColumn(name = "SizeUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    private UnitMeasure sizeUnitMeasure;

    @ManyToOne
    @JoinColumn(name = "WeightUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    private UnitMeasure weightUnitMeasure;

    @Column(name = "Weight", precision = 8, scale = 2)
    private BigDecimal weight;

    @Column(name = "DaysToManufacture", nullable = false)
    private int daysToManufacture;

    @Column(name = "ProductLine", length = 2)
    private String productLine;

    @Column(name = "Class", length = 2)
    private String clazz;

    @Column(name = "Style", length = 2)
    private String style;

    @ManyToOne
    @JoinColumn(name = "ProductSubcategoryID", nullable = false)
    private ProductSubcategory productSubcategory;

    @ManyToOne
    @JoinColumn(name = "ProductModelID", nullable = false)
    private ProductModel productModel;

    @Column(name = "SellStartDate", nullable = false)
    private LocalDateTime sellStartDate;

    @Column(name = "SellEndDate")
    private LocalDateTime sellEndDate;

    @Column(name = "DiscontinuedDate")
    private LocalDateTime discontinuedDate;

    @Column(name = "rowguid", nullable = false, columnDefinition = "uniqueidentifier")
    private UUID rowguid;

    @Column(name = "ModifiedDate", nullable = false)
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductDocument> productDocuments;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ProductReview> productReviews;

    // Getters and Setters

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public boolean isMakeFlag() {
        return makeFlag;
    }

    public void setMakeFlag(boolean makeFlag) {
        this.makeFlag = makeFlag;
    }

    public boolean isFinishedGoodsFlag() {
        return finishedGoodsFlag;
    }

    public void setFinishedGoodsFlag(boolean finishedGoodsFlag) {
        this.finishedGoodsFlag = finishedGoodsFlag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getSafetyStockLevel() {
        return safetyStockLevel;
    }

    public void setSafetyStockLevel(short safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
    }

    public int getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public UnitMeasure getSizeUnitMeasure() {
        return sizeUnitMeasure;
    }

    public void setSizeUnitMeasure(UnitMeasure sizeUnitMeasure) {
        this.sizeUnitMeasure = sizeUnitMeasure;
    }

    public UnitMeasure getWeightUnitMeasure() {
        return weightUnitMeasure;
    }

    public void setWeightUnitMeasure(UnitMeasure weightUnitMeasure) {
        this.weightUnitMeasure = weightUnitMeasure;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getDaysToManufacture() {
        return daysToManufacture;
    }

    public void setDaysToManufacture(int daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public ProductSubcategory getProductSubcategory() {
        return productSubcategory;
    }

    public void setProductSubcategory(ProductSubcategory productSubcategory) {
        this.productSubcategory = productSubcategory;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public LocalDateTime getSellStartDate() {
        return sellStartDate;
    }

    public void setSellStartDate(LocalDateTime sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    public LocalDateTime getSellEndDate() {
        return sellEndDate;
    }

    public void setSellEndDate(LocalDateTime sellEndDate) {
        this.sellEndDate = sellEndDate;
    }

    public LocalDateTime getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(LocalDateTime discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
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

    public Set<ProductDocument> getProductDocuments() {
        return productDocuments;
    }

    public void setProductDocuments(Set<ProductDocument> productDocuments) {
        this.productDocuments = productDocuments;
    }

    public Set<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(Set<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }
}
