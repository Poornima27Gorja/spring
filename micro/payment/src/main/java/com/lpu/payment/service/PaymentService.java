package com.lpu.payment.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.lpu.payment.entity.Payment;
import com.lpu.payment.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment pay(Payment payment) {
        return repo.save(payment);
    }

    public List<Payment> getAll() {
        return repo.findAll();
    }
}