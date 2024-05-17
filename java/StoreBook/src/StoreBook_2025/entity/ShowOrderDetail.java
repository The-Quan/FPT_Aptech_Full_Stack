package StoreBook_2025.entity;

public class ShowOrderDetail {
    private Orders order;
    private Customers customer;
    private Products product;
    private OrderDetail orderDetail;

    // Constructor, Getters, and Setters


    public ShowOrderDetail(Orders order, Customers customer, Products product, OrderDetail orderDetail) {
        this.order = order;
        this.customer = customer;
        this.product = product;
        this.orderDetail = orderDetail;
    }

    public ShowOrderDetail() {

    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
