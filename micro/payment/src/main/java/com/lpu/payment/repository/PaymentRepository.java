package com.lpu.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}