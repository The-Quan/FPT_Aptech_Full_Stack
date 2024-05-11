package session14_gennerrics.entity;

import java.util.Date;
import java.util.List;

public class Order extends Entity<Integer>{
    private int customerid;
    private Date createAt;
    private String paymentType;
    // 1 - N: Order - OrderDetail (ORM)
    private List<OrderDetail> orderDetails;

    public Order(Integer id) {
        super(id);
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
