package com.lpu.loan.controller;

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

import com.lpu.loan.entity.Loan;
import com.lpu.loan.service.LoanService;

@RequestMapping("/loan")
@RestController
public class LoanController {

	@Autowired
	private LoanService service;
	
	@PostMapping("/save")
	public Loan saveLoan(@RequestBody Loan loan) {
		return service.addLoan(loan);
	}
	
	@GetMapping("/find/{loanId}")
	public Loan findLoanById(@PathVariable int loanId) {
		return service.findLoan(loanId);
	}
	
	@GetMapping("/findAll")
	public List<Loan> findAllLoans() {
		return service.findLoans();
	}
	
	@PutMapping("/update/{loanId}")
	public Loan updateLoanById(@PathVariable int loanId, @RequestBody Loan loan) {
		return service.updateLoan(loanId, loan);
	}
	
	@DeleteMapping("/delete/{loanId}")
	public void deleteLoanById(@PathVariable int loanId) {
		service.deleteLoan(loanId);
	}
}
