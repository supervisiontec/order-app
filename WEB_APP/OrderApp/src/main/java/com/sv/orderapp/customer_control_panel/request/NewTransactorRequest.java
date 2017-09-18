/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.customer_control_panel.request;

/**
 *
 * @author Mohan
 */
public class NewTransactorRequest {

    private Integer indexNo;
    private Integer route;
    private String name;
    private String contactPerson;
    private String mobile;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String telephone1;
    private String telephone2;
    private String fax;
    private String email;
    private double creditLimit;
    private double creditAmount;
    private boolean client;
    private boolean supplier;
    private boolean approved;
    private boolean active;

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
