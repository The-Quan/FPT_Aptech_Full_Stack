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

}
