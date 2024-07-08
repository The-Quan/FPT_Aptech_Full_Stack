package org.example.doanki2.controller;

import org.example.doanki2.entity.Payment_Methods;
import org.example.doanki2.model.paymentMethods.PayMentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paymentmethods/v1/")
@CrossOrigin(origins = "http://localhost:3000")

public class PayMentMethodsController {
    @Autowired
    private PayMentMethodsService payMentMethodsService;

    @GetMapping
    public ResponseEntity<List<Payment_Methods>> getAll(){
        return payMentMethodsService.getAllPayment();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Payment_Methods> getById(@PathVariable Integer id){
        return payMentMethodsService.getByIdPayment(id);
    }
    @PostMapping
    public ResponseEntity<Payment_Methods> postPayment(@RequestBody Payment_Methods paymentMethods){
        return payMentMethodsService.postPayment(paymentMethods);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Payment_Methods> putPayment(@PathVariable Integer id, @RequestBody Payment_Methods paymentMethods){
        return payMentMethodsService.putPayment(id, paymentMethods);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Payment_Methods> delete(@PathVariable Integer id){
        return payMentMethodsService.deletePayment(id);
    }

}
