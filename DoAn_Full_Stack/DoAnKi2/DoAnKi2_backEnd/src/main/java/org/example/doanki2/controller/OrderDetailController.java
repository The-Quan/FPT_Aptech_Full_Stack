package org.example.doanki2.controller;

import org.example.doanki2.entity.Order_Details;
import org.example.doanki2.model.orderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderdetail/v1/")
@CrossOrigin(origins = "http://localhost:3000")

public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<Page<Order_Details>> getAll(Pageable pageable){
        return orderDetailService.getAllOrderDetail(pageable);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order_Details> getById(@PathVariable Integer id){
        return orderDetailService.getByIdOrderDetail(id);
    }
    @PostMapping
    public ResponseEntity<Order_Details> post(@RequestBody Order_Details orderDetails){
        return orderDetailService.postOrderDetail(orderDetails);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order_Details> put(@PathVariable Integer id, @RequestBody Order_Details orderDetails){
        return orderDetailService.putOrderDetail(id, orderDetails);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Order_Details> delete(@PathVariable Integer id){
        return orderDetailService.deleteOrderDetail(id);
    }
}
