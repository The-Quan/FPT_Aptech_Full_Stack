package org.example.doanki2.model.paymentMethods;

import org.example.doanki2.entity.Payment_Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PayMentMethodsService {
    @Autowired
    private PaymentMethodsRepository paymentMethodsRepository;

    public ResponseEntity<List<Payment_Methods>> getAllPayment(){
        List<Payment_Methods> paymentMethodsList = paymentMethodsRepository.findAll();
        return ResponseEntity.ok(paymentMethodsList);
    }

    public ResponseEntity<Payment_Methods> getByIdPayment(int id){
        Optional<Payment_Methods> optionalPaymentMethods = paymentMethodsRepository.findById(id);
        if (!optionalPaymentMethods.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        return ResponseEntity.ok().body(optionalPaymentMethods.get());
    }
    public ResponseEntity<Payment_Methods> postPayment(Payment_Methods paymentMethods){
        Payment_Methods paymentMethods1 = paymentMethodsRepository.save(paymentMethods);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paymentMethods1.getPayment_method_id()).toUri();

        return ResponseEntity.created(location).body(paymentMethods1);
    }
    public ResponseEntity<Payment_Methods> putPayment(int id, Payment_Methods paymentMethods){
        Optional<Payment_Methods> paymentMethodsOptional = paymentMethodsRepository.findById(id);
        if (!paymentMethodsOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        paymentMethods.setPayment_method_id(paymentMethodsOptional.get().getPayment_method_id());
        paymentMethodsRepository.save(paymentMethods);

        return ResponseEntity.ok().body(paymentMethods);
    }
    public ResponseEntity<Payment_Methods> deletePayment(int id){
        Optional<Payment_Methods> optionalPaymentMethods = paymentMethodsRepository.findById(id);
        if (!optionalPaymentMethods.isPresent()) {
            throw new IllegalArgumentException("id not found");
        }
        paymentMethodsRepository.deleteById(optionalPaymentMethods.get().getPayment_method_id());
        return ResponseEntity.noContent().build();
    }

}
