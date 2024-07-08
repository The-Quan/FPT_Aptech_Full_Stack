package org.example.doanki2.model.orderDetail;

import org.example.doanki2.entity.Order_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_Details, Integer> {
}
