package com.lpu.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.loan.entity.Loan;
import com.lpu.loan.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repository;
	
	public Loan addLoan(Loan loan) {
		return repository.save(loan);
	}
	
	public Loan findLoan(int loanId) {
		return repository.findById(loanId).orElse(null);
	}
	
	 public List<Loan> findLoans() {
		 return repository.findAll();
	 }
	 
	 public Loan updateLoan(int loanId, Loan loan) {
		 Loan l = repository.findById(loanId).orElse(null);
		 
		 l.setLoanType(loan.getLoanType());
		 l.setLoanAmount(loan.getLoanAmount());
		 
		 return repository.save(l);
	 }
	 
	 public void deleteLoan(int loanId) {
		 repository.deleteById(loanId);
	 }
}
