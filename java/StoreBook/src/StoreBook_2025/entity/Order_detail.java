package StoreBook_2025.entity;

import java.util.Date;

public class Order_detail {
    private int orderDetail_id;
    private int order_id;
    private int customer_id;
    private String customer_name;
    private int product_id;
    private String product_name;
    private String address;
    private Date datetimes;
    private double total;

    public Order_detail(int orderDetail_id, int order_id, int customer_id, String customer_name, int product_id, String product_name, String address, Date datetimes, double total) {
        this.orderDetail_id = orderDetail_id;
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.product_id = product_id;
        this.product_name = product_name;
        this.address = address;
        this.datetimes = datetimes;
        this.total = total;
    }

    public Order_detail() {

    }

    public int getOrderDetail_id() {
        return orderDetail_id;
    }

    public void setOrderDetail_id(int orderDetail_id) {
        this.orderDetail_id = orderDetail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.sql.Date getdatetimes() {
        return (java.sql.Date) datetimes;
    }

    public void setdatetimes(Date datetimes) {
        this.datetimes = datetimes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
