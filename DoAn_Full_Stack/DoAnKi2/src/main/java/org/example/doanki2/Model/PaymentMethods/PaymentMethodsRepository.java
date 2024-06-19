package org.example.doanki2.Model.PaymentMethods;

import org.example.doanki2.Entity.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {
}
