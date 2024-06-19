package org.example.doanki2.Model.PaymentMethods;

import org.example.doanki2.Entity.PaymentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayMentMethodsService {
    @Autowired
    private PaymentMethodsRepository paymentMethodsRepository;

    public List<PaymentMethods> getPaymentMethods() {
        return paymentMethodsRepository.findAll();
    }
    public PaymentMethods getByIdPaymentMethod(int id) {
       if (paymentMethodsRepository.existsById(id)) {
           return paymentMethodsRepository.findById(id).get();
       }
       return null;
    }
    public PaymentMethods save(PaymentMethods paymentMethods) {
        return paymentMethodsRepository.save(paymentMethods);
    }
    public PaymentMethods update(PaymentMethods paymentMethods) {
        Optional<PaymentMethods> paymentMethodsOptional = paymentMethodsRepository.findById(paymentMethods.getPayment_method_id());
        PaymentMethods paymentMethodsUpdated = paymentMethodsOptional.get();
        paymentMethodsUpdated.setMethod_name(paymentMethods.getMethod_name());
        paymentMethodsUpdated.setDescription(paymentMethods.getDescription());
        return paymentMethodsRepository.save(paymentMethodsUpdated);
    }
    public PaymentMethods deleteById(int id) {
        if (paymentMethodsRepository.existsById(id)) {
            paymentMethodsRepository.deleteById(id);
        }
        return null;
    }

}
