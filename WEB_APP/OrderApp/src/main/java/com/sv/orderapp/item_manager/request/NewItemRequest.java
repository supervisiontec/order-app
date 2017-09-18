/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.item_manager.request;

/**
 *
 * @author Mohan
 */
public class NewItemRequest {

    private Integer indexNo;
    private String code;
    private String name;
    private String printDescription;
    private Integer supplier;
    private Integer department;
    private Integer mainCategory;
    private Integer subCategory;
    private String defaultUnit;
    private double costPrice;
    private double retailPrice;
    private double maxDiscountPercent;
    private boolean active;

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
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

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
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

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getMaxDiscountPercent() {
        return maxDiscountPercent;
    }

    public void setMaxDiscountPercent(double maxDiscountPercent) {
        this.maxDiscountPercent = maxDiscountPercent;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
