package org.example.doanki2.Controller;

import org.example.doanki2.Entity.OrderDetails;
import org.example.doanki2.Model.OrderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetail/v1/")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public OrderDetails getOrderDetail(@PathVariable Integer id) {
        OrderDetails orderDetails = orderDetailService.getOrderDetailById(id);
        if (orderDetails == null || !id.equals(orderDetails.getOrder_detail_id())) {
            throw new IllegalArgumentException("id is not correct");
        }
        return orderDetails;
    }
    @PostMapping
    public OrderDetails addOrderDetail(@RequestBody OrderDetails orderDetails) {
        return orderDetailService.saveOrderDetail(orderDetails);
    }
    @PutMapping("/{id}")
    public OrderDetails updateOrderDetail(@PathVariable Integer id, @RequestBody OrderDetails orderDetails) {
        if (orderDetailService.getOrderDetailById(id) == null || !id.equals(orderDetails.getOrder_detail_id())) {
            throw new IllegalArgumentException("id is not correct");
        }
        return orderDetailService.updateOrderDetail(orderDetails);
    }
    @DeleteMapping("/{id}")
    public OrderDetails deleteOrderDetail(@PathVariable Integer id) {
        if (orderDetailService.getOrderDetailById(id) == null || !id.equals(orderDetailService.getOrderDetailById(id).getOrder_detail_id())) {
            throw new IllegalArgumentException("id is not correct");
        }
        return orderDetailService.deleteOrderDetail(id);
    }
}
