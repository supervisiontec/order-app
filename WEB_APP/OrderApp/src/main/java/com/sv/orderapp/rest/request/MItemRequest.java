package com.sv.orderapp.rest.request;

/**
 * Created by Mohan on 5/22/2016.
 */
public class MItemRequest {
    private int indexNo;
    private String code;
    private String name;
    private String printDescription;
    private MDepartmentRequest department;
    private MMainCategoryRequest mainCategory;
    private MSubCategoryRequest subCategory;
    private double costPrice;
    private double retailPrice;
    private double maxDiscountPercent;
    private int version;

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
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

    public MDepartmentRequest getDepartment() {
        return department;
    }

    public void setDepartment(MDepartmentRequest department) {
        this.department = department;
    }

    public MMainCategoryRequest getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(MMainCategoryRequest mainCategory) {
        this.mainCategory = mainCategory;
    }

    public MSubCategoryRequest getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(MSubCategoryRequest subCategory) {
        this.subCategory = subCategory;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
