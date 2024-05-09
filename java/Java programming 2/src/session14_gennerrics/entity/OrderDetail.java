package session14_gennerrics.entity;

import java.util.Date;

public class OrderDetail extends Entity<Integer>{
    private int orderId;
    private Date createAt;
    private int productId;

    public OrderDetail(Integer id) {
        super(id);
    }
}
