package com.sv.ordermobile.model;

/**
 * Created by Mohan on 5/19/2016.
 */
public class MItem {
    private String code;
    private String name;
    private String printDescription;
    private String supplier;
    private Integer department;
    private Integer mainCategory;
    private Integer subCategory;
    private String defaultUnit;
    private double costPrice;
    private double wholeSalePrice;
    private double lastSalePrice;
    private double salePrice;
    private boolean active;

    public MItem() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintDescription() {
        return printDescription;
    }

    public void setPrintDescription(String printDescription) {
        this.printDescription = printDescription;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(Integer mainCategory) {
        this.mainCategory = mainCategory;
    }

    public Integer getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Integer subCategory) {
        this.subCategory = subCategory;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getWholeSalePrice() {
        return wholeSalePrice;
    }

    public void setWholeSalePrice(double wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    public double getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(double lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
