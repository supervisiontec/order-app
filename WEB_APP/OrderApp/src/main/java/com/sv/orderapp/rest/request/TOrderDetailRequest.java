package com.sv.orderapp.rest.request;

/**
 * Created by Mohan on 5/23/2016.
 */
public class TOrderDetailRequest {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_APPROVED = "APPROVED";


    private int indexNo;
    private int serverId;
    private int orderSummary;
    private MItemRequest item;
    private double costPrice;
    private double retailPrice;
    private double maxDiscountPercent;
    private double quantity;
    private double discountPercent;
    private double itemValue;
    private double discountValue;
    private double netValue;
    private int version;

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getOrderSummary() {
        return orderSummary;
    }

    public void setOrderSummary(int orderSummary) {
        this.orderSummary = orderSummary;
    }

    public MItemRequest getItem() {
        return item;
    }

    public void setItem(MItemRequest item) {
        this.item = item;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getItemValue() {
        return itemValue;
    }

    public void setItemValue(double itemValue) {
        this.itemValue = itemValue;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public double getNetValue() {
        return netValue;
    }

    public void setNetValue(double netValue) {
        this.netValue = netValue;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
