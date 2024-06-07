package com.example.webservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProductDTO {
    private int productId;
    private String name;
    private String productNumber;
    private boolean makeFlag;
    private boolean finishedGoodsFlag;
    private String color;
    private short safetyStockLevel;
    private int reorderPoint;
    private BigDecimal standardCost;
    private BigDecimal listPrice;
    private String size;
    private String sizeUnitMeasureCode;
    private String weightUnitMeasureCode;
    private BigDecimal weight;
    private int daysToManufacture;
    private String productLine;
    private String clazz;
    private String style;
    private Integer productSubcategoryId;
    private String subcategoryName;
    private Integer productModelId;
    private String productModelName;
    private LocalDateTime sellStartDate;
    private LocalDateTime sellEndDate;
    private LocalDateTime discontinuedDate;
    private UUID rowguid;
    private LocalDateTime modifiedDate;

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

    public String getSizeUnitMeasureCode() {
        return sizeUnitMeasureCode;
    }

    public void setSizeUnitMeasureCode(String sizeUnitMeasureCode) {
        this.sizeUnitMeasureCode = sizeUnitMeasureCode;
    }

    public String getWeightUnitMeasureCode() {
        return weightUnitMeasureCode;
    }

    public void setWeightUnitMeasureCode(String weightUnitMeasureCode) {
        this.weightUnitMeasureCode = weightUnitMeasureCode;
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

    public Integer getProductSubcategoryId() {
        return productSubcategoryId;
    }

    public void setProductSubcategoryId(Integer productSubcategoryId) {
        this.productSubcategoryId = productSubcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Integer getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(Integer productModelId) {
        this.productModelId = productModelId;
    }

    public String getProductModelName() {
        return productModelName;
    }

    public void setProductModelName(String productModelName) {
        this.productModelName = productModelName;
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
}
