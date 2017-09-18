package sv.com.orderapp.model;

import java.util.Date;

/**
 * Created by Mohan on 5/22/2016.
 */
public class MTransactor {
    private int indexNo;
    private int serverId;
    private String name;
    private String contactPerson;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String mobile;
    private String telephone1;
    private String telephone2;
    private String fax;
    private int route;
    private double creditAmount;
    private double creditLimit;
    private boolean client;
    private boolean supplier;
    private Date lastVisitedDate;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
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

    public Date getLastVisitedDate() {
        return lastVisitedDate;
    }

    public void setLastVisitedDate(Date lastVisitedDate) {
        this.lastVisitedDate = lastVisitedDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
