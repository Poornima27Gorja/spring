package com.lpu.payment.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.lpu.payment.entity.Payment;
import com.lpu.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Payment pay(@RequestBody Payment payment) {
        return service.pay(payment);
    }

    @GetMapping("get")
    public List<Payment> getAll() {
        return service.getAll();
    }
}