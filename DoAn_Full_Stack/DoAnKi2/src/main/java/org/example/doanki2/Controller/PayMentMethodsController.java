package org.example.doanki2.Controller;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import org.example.doanki2.Entity.PaymentMethods;
import org.example.doanki2.Model.PaymentMethods.PayMentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

@RestController
@RequestMapping("/api/paymentmethods/v1/")
public class PayMentMethodsController {
    @Autowired
    private PayMentMethodsService payMentMethodsService;

    @GetMapping
    public List<PaymentMethods> getAllPaymentMethods() {
        return payMentMethodsService.getPaymentMethods();
    }
    @GetMapping("/{id}")
    public PaymentMethods getPaymentMethodById(@PathVariable Integer id) {
     PaymentMethods paymentMethods = payMentMethodsService.getByIdPaymentMethod(id);
     if (paymentMethods == null || !id.equals(paymentMethods.getPayment_method_id())){
         throw new IllegalArgumentException("Invalid payment method id");
     }
     return paymentMethods;
    }
    @PostMapping
    public PaymentMethods createPaymentMethod(@RequestBody PaymentMethods paymentMethods) {
        return payMentMethodsService.save(paymentMethods);
    }
    @PutMapping("/{id}")
    public PaymentMethods updatePaymentMethod(@PathVariable Integer id, @RequestBody PaymentMethods paymentMethods) {
        if (paymentMethods == null || !id.equals(paymentMethods.getPayment_method_id())){
            throw new IllegalArgumentException("Invalid payment method id");
        }
        return payMentMethodsService.update(paymentMethods);
    }
    @DeleteMapping("/{id}")
    public PaymentMethods deletePaymentMethod(@PathVariable Integer id) {
        if (!id.equals(payMentMethodsService.getByIdPaymentMethod(id).getPayment_method_id())){
            throw new IllegalArgumentException("Invalid payment method id");
        }
        return payMentMethodsService.deleteById(id);
    }

}
