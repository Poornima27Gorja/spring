package com.lpu.deposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.deposit.entity.Deposit;
import com.lpu.deposit.repository.DepositRepository;

@Service
public class DepositService {

	@Autowired
	private DepositRepository repository;
	
	public Deposit addDeposit(Deposit deposit) {
		return repository.save(deposit);
	}
	
	public Deposit findDeposit(int depositId) {
		return repository.findById(depositId).orElse(null);
	}
	
	 public List<Deposit> findDeposits() {
		 return repository.findAll();
	 }
	 
	 public Deposit updateDeposit(int depositId, Deposit deposit) {
		 Deposit d = repository.findById(depositId).orElse(null);
		 
		 d.setDepositType(deposit.getDepositType());
		 d.setDepositAmount(deposit.getDepositAmount());
		 
		 return repository.save(d);
	 }
	 
	 public void deleteDeposit(int depositId) {
		 repository.deleteById(depositId);
	 }
}
