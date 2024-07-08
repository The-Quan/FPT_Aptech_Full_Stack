package org.example.doanki2.model.orderDetail;

import org.example.doanki2.entity.Order_Details;
import org.example.doanki2.entity.Orders;
import org.example.doanki2.entity.Products;
import org.example.doanki2.model.orders.OrderRepository;
import org.example.doanki2.model.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<Page<Order_Details>> getAllOrderDetail(Pageable pageable){
       return ResponseEntity.ok(orderDetailRepository.findAll(pageable));
    }

    public ResponseEntity<Order_Details> getByIdOrderDetail(int id){
        Optional<Order_Details> orderDetails = orderDetailRepository.findById(id);
        if (!orderDetails.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        return ResponseEntity.ok().body(orderDetails.get());
    }
    public ResponseEntity<Order_Details> postOrderDetail(Order_Details orderDetails){
        Optional<Orders> ordersOptional = orderRepository.findById(orderDetails.getOrders().getOrder_id());
        if (!ordersOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        Optional<Products> productsOptional = productRepository.findById(orderDetails.getProducts().getProduct_id());
        if(!productsOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        orderDetails.setOrders(ordersOptional.get());
        orderDetails.setProducts(productsOptional.get());

        Order_Details orderDetailsSave = orderDetailRepository.save(orderDetails);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderDetails.getOrder_detail_id()).toUri();

        return ResponseEntity.created(location).body(orderDetailsSave);
    }
    public ResponseEntity<Order_Details> putOrderDetail(int id, Order_Details orderDetails){
        Optional<Order_Details> orderDetailsOptional = orderDetailRepository.findById(id);
        if (!orderDetailsOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        Optional<Orders> ordersOptional = orderRepository.findById(orderDetails.getOrders().getOrder_id());
        if (!ordersOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        Optional<Products> productsOptional = productRepository.findById(orderDetails.getProducts().getProduct_id());
        if (!productsOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        orderDetails.setOrder_detail_id(orderDetailsOptional.get().getOrder_detail_id());
        orderDetails.setOrders(ordersOptional.get());
        orderDetails.setProducts(productsOptional.get());

        Order_Details saveOrderDetail = orderDetailRepository.save(orderDetails);

        return ResponseEntity.ok().body(saveOrderDetail);
    }

    public ResponseEntity<Order_Details> deleteOrderDetail(int id){
        Optional<Order_Details> orderDetails = orderDetailRepository.findById(id);
        if (!orderDetails.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        orderDetailRepository.deleteById(orderDetails.get().getOrder_detail_id());

        return ResponseEntity.noContent().build();
    }

}
