package org.example.doanki2.model.paymentMethods;

import org.example.doanki2.entity.Payment_Methods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<Payment_Methods, Integer> {
}
