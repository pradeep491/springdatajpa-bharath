package com.test.springdata.repository;

import com.test.springdata.entities.tableperclass.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
