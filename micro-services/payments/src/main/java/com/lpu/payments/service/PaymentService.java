package com.lpu.payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.payments.entity.Payment;
import com.lpu.payments.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	public Payment savePayment(Payment payment) {
		return repository.save(payment);
	}
	
	public Payment findPaymentById(int paymentId) {
		return repository.findById(paymentId).orElse(null);
	}
	
	public List<Payment> findAllPayments() {
		return repository.findAll();
	}
	
	public Payment updatePaymentById(int paymentId, Payment payment) {
		Payment p = repository.findById(paymentId).orElse(null);
		
		p.setPaymentName(payment.getPaymentName());
		p.setPaymentType(payment.getPaymentType());
		
		return repository.save(p);
	}
	
	public void deletePaymentById(int paymentId) {
		repository.deleteById(paymentId);
	}
	
}
