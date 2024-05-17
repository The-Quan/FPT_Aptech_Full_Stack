package StoreBook_2025.entity;

import java.util.Date;

public class OrderDetail {
    private int orderDetail_id;
    private int order_id;
    private int customer_id;
    private int product_id;
    private Date date;
    private double total;

    public OrderDetail(int orderDetail_id, int order_id, int customer_id, int product_id, Date date, double total) {
        this.orderDetail_id = orderDetail_id;
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.date = date;
        this.total = total;
    }

    public OrderDetail() {

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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Date getDatetimes() {
        return date;
    }

    public void setDatetimes(Date datetimes) {
        this.date = datetimes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
