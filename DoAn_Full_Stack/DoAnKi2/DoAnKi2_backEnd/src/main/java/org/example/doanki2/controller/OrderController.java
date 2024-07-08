package org.example.doanki2.controller;

import org.example.doanki2.entity.Orders;
import org.example.doanki2.model.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Orders>> getAll(){
        return orderService.getAllOrder();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getById(@PathVariable Integer id){
        return orderService.getById(id);
    }
    @PostMapping
    public ResponseEntity<Orders> post(@RequestBody Orders orders){
        return orderService.postOrder(orders);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Orders> put(@PathVariable Integer id, @RequestBody Orders orders){
        return orderService.putOrder(id, orders);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> delete(@PathVariable Integer id){
        return orderService.deleteOrder(id);
    }
}
