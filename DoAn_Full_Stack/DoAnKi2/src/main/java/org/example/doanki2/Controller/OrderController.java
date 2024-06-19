package org.example.doanki2.Controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.doanki2.Entity.Orders;
import org.example.doanki2.Model.Orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order/v1/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Integer id) {
       Orders order = orderService.getOrderById(id);
       if (order == null || !id.equals(order.getOrder_id())) {
           throw new IllegalArgumentException("Order not found");
       }
       return order;
    }

    @PostMapping
    public Orders getOrderById(Orders order) {
       return orderService.addOrder(order);
    }
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Integer id,@RequestBody Orders order) {
        if (orderService.getOrderById(id) == null || !id.equals(order.getOrder_id())) {
            throw new IllegalArgumentException("Invalid order id");
        }
        return orderService.updateOrder(order);
    }
    @DeleteMapping("/{id}")
    public Orders deleteOrder(@PathVariable Integer id) {
        if (!id.equals(orderService.getOrderById(id).getOrder_id())) {
            throw new IllegalArgumentException("Invalid order id");
        }
        return orderService.deleteOrder(id);
    }

}
