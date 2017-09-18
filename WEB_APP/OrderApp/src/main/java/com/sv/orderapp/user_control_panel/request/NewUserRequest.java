/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.user_control_panel.request;

/**
 *
 * @author Mohan
 */
public class NewUserRequest {

    private Integer indexNo;
    private String name;
    private String username;
    private String password;
    private boolean itemControlPanel;
    private boolean customerControlPanel;
    private boolean supplierControlPanel;
    private boolean userControlPanel;
    private boolean customerApproval;
    private boolean orderApproval;
    private boolean reports;
    private boolean mobileApp;
    private boolean active;

    public NewUserRequest() {
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isItemControlPanel() {
        return itemControlPanel;
    }

    public void setItemControlPanel(boolean itemControlPanel) {
        this.itemControlPanel = itemControlPanel;
    }

    public boolean isCustomerControlPanel() {
        return customerControlPanel;
    }

    public void setCustomerControlPanel(boolean customerControlPanel) {
        this.customerControlPanel = customerControlPanel;
    }

    public boolean isSupplierControlPanel() {
        return supplierControlPanel;
    }

    public void setSupplierControlPanel(boolean supplierControlPanel) {
        this.supplierControlPanel = supplierControlPanel;
    }

    public boolean isUserControlPanel() {
        return userControlPanel;
    }

    public void setUserControlPanel(boolean userControlPanel) {
        this.userControlPanel = userControlPanel;
    }

    public boolean isCustomerApproval() {
        return customerApproval;
    }

    public void setCustomerApproval(boolean customerApproval) {
        this.customerApproval = customerApproval;
    }

    public boolean isOrderApproval() {
        return orderApproval;
    }

    public void setOrderApproval(boolean orderApproval) {
        this.orderApproval = orderApproval;
    }

    public boolean isReports() {
        return reports;
    }

    public void setReports(boolean reports) {
        this.reports = reports;
    }

    public boolean isMobileApp() {
        return mobileApp;
    }

    public void setMobileApp(boolean mobileApp) {
        this.mobileApp = mobileApp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
