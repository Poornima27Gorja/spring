package com.lpu.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.loan.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
}
