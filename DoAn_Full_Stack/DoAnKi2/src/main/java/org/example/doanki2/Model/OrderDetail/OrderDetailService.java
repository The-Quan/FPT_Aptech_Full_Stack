package org.example.doanki2.Model.OrderDetail;

import org.example.doanki2.Entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public OrderDetails getOrderDetailById(int id) {
        if (orderDetailRepository.existsById(id)) {
            return orderDetailRepository.findById(id).get();
        }
        return null;
    }
    public OrderDetails saveOrderDetail(OrderDetails orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
    public OrderDetails updateOrderDetail(OrderDetails orderDetail) {
        Optional<OrderDetails> orderDetails = orderDetailRepository.findById(orderDetail.getOrder_detail_id());
        if (orderDetails.isPresent()) {
            OrderDetails orderDetail_update = orderDetails.get();
            orderDetail_update.setOrders(orderDetail.getOrders());
            orderDetail_update.setProducts(orderDetail.getProducts());
            orderDetail_update.setQuantity(orderDetail.getQuantity());
            return orderDetailRepository.save(orderDetail_update);
        }
        return null;
    }
    public OrderDetails deleteOrderDetail(int id) {
        if(orderDetailRepository.findById(id).isPresent()) {
            orderDetailRepository.deleteById(id);
        }
        return null;
    }

}
