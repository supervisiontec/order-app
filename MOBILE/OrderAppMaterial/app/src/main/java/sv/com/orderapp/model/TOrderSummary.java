package sv.com.orderapp.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Mohan on 5/26/2016.
 */
public class TOrderSummary {
    public static final String PAYMENT_CASH = "CASH";
    public static final String PAYMENT_CHEQUE= "CHEQUE";
    public static final String PAYMENT_CREDIT= "CREDIT";

    private int indexNo;
    private int serverId;
    private Date orderDate;
    private int client;
    private double totalItemValue;
    private double itemDiscountValue;
    private double specialDiscountPercent;
    private double specialDiscountValue;
    private double netValue;
    private String paymentMethod;
    private int orderByUser;
    private int approvedByUser;
    private Date approvedDate;
    private String status;
    private int version;

    private List<TOrderDetail> orderDetails;

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public double getTotalItemValue() {
        return totalItemValue;
    }

    public void setTotalItemValue(double totalItemValue) {
        this.totalItemValue = totalItemValue;
    }

    public double getItemDiscountValue() {
        return itemDiscountValue;
    }

    public void setItemDiscountValue(double itemDiscountValue) {
        this.itemDiscountValue = itemDiscountValue;
    }

    public double getSpecialDiscountPercent() {
        return specialDiscountPercent;
    }

    public void setSpecialDiscountPercent(double specialDiscountPercent) {
        this.specialDiscountPercent = specialDiscountPercent;
    }

    public double getSpecialDiscountValue() {
        return specialDiscountValue;
    }

    public void setSpecialDiscountValue(double specialDiscountValue) {
        this.specialDiscountValue = specialDiscountValue;
    }

    public double getNetValue() {
        return netValue;
    }

    public void setNetValue(double netValue) {
        this.netValue = netValue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getOrderByUser() {
        return orderByUser;
    }

    public void setOrderByUser(int orderByUser) {
        this.orderByUser = orderByUser;
    }

    public int getApprovedByUser() {
        return approvedByUser;
    }

    public void setApprovedByUser(int approvedByUser) {
        this.approvedByUser = approvedByUser;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<TOrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<TOrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
