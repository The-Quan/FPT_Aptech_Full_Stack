package session10.entity;

import java.util.Date;

public class Order {
    private int order_id;
    private int customerid;
    private Date date;

    public Order(int order_id, int customerid, Date date) {
        this.order_id = order_id;
        this.customerid = customerid;
        this.date = date;
    }

    public Order() {

    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int ID2) {
        this.customerid = ID2;
    }

    public Date getDate() {
        return  date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", customerid=" + customerid +
                ", date=" + date +
                '}';
    }

}
