package session14_gennerrics.entity;

import java.util.Date;

public class OrderDetail extends Entity<Integer>{
    private int orderId;
    private Date createAt;
    private int productId;

    public OrderDetail(Integer id) {
        super(id);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
