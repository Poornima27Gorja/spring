package com.lpu.deposit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.deposit.entity.Deposit;
import com.lpu.deposit.service.DepositService;

@RequestMapping("/deposit")
@RestController
public class DepositController {

	@Autowired
	private DepositService service;
	
	@PostMapping("/save")
	public Deposit saveDeposit(@RequestBody Deposit deposit) {
		return service.addDeposit(deposit);
	}
	
	@GetMapping("/find/{depositId}")
	public Deposit findDepositById(@PathVariable int depositId) {
		return service.findDeposit(depositId);
	}
	
	@GetMapping("/findAll")
	public List<Deposit> findAllDeposits() {
		return service.findDeposits();
	}
	
	@PutMapping("/update/{depositId}")
	public Deposit updateDepositById(@PathVariable int depositId, @RequestBody Deposit deposit) {
		return service.updateDeposit(depositId, deposit);
	}
	
	@DeleteMapping("/delete/{depositId}")
	public void deleteDepositById(@PathVariable int depositId) {
		service.deleteDeposit(depositId);
	}
}
