package org.example.doanki2.model.orders;

import org.example.doanki2.entity.Orders;
import org.example.doanki2.entity.Payment_Methods;
import org.example.doanki2.entity.Users;
import org.example.doanki2.model.paymentMethods.PaymentMethodsRepository;
import org.example.doanki2.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentMethodsRepository paymentMethodsRepository;

    public ResponseEntity<List<Orders>> getAllOrder(){
        List<Orders> ordersList = orderRepository.findAll();
        return ResponseEntity.ok(ordersList);
    }
    public ResponseEntity<Orders> getById(int id){
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        if (!optionalOrders.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        return ResponseEntity.ok(optionalOrders.get());
    }
    public ResponseEntity<Orders> postOrder(Orders orders){
        Optional<Users> usersOptional = userRepository.findById(orders.getUser().getUser_id());
        if (!usersOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        Optional<Payment_Methods> paymentMethodsOptional = paymentMethodsRepository.findById(orders.getPaymentMethods().getPayment_method_id());
        if (!paymentMethodsOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        orders.setUser(usersOptional.get());
        orders.setPaymentMethods(paymentMethodsOptional.get());
        Orders orderSave = orderRepository.save(orders);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderSave.getOrder_id()).toUri();

        return ResponseEntity.created(location).body(orderSave);
    }
    public ResponseEntity<Orders> putOrder(int id,Orders orders){
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        if (!optionalOrders.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        Optional<Users> usersOptional = userRepository.findById(orders.getUser().getUser_id());
        if (!usersOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        Optional<Payment_Methods> paymentMethodsOptional = paymentMethodsRepository.findById(orders.getPaymentMethods().getPayment_method_id());
        if (!paymentMethodsOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        orders.setOrder_id(optionalOrders.get().getOrder_id());
        orders.setUser(usersOptional.get());
        orders.setPaymentMethods(paymentMethodsOptional.get());

        orderRepository.save(orders);
        return ResponseEntity.ok().body(orders);
    }

    public ResponseEntity<Orders> deleteOrder(int id){
        Optional<Orders> ordersOptional = orderRepository.findById(id);
        if (!ordersOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        orderRepository.deleteById(ordersOptional.get().getOrder_id());

        return ResponseEntity.noContent().build();
    }
}
