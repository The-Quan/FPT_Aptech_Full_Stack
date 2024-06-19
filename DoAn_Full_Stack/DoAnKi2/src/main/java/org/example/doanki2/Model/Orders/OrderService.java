package org.example.doanki2.Model.Orders;

import org.example.doanki2.Entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
    public Orders getOrderById(int id) {
        Optional<Orders> order = orderRepository.findById(id);
       if (order.isPresent()) {
           return order.get();
       }
       return null;
    }
    public Orders addOrder(Orders order) {
        return orderRepository.save(order);
    }
    public Orders updateOrder(Orders order) {
        Optional<Orders> optionalOrders = orderRepository.findById(order.getOrder_id());
        if (optionalOrders.isPresent()) {
            Orders newOrder = optionalOrders.get();
            newOrder.setUser(order.getUser());
            newOrder.setTotal_amount(order.getTotal_amount());
            newOrder.setStatus(order.getStatus());
            newOrder.setPaymentMethods(order.getPaymentMethods());
            return orderRepository.save(newOrder);
        }
       throw new IllegalArgumentException("Order not found");
    }
    public Orders deleteOrder(int id) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
        }
        return null;
    }
}
