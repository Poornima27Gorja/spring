package com.lpu.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.security1.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{
	
	Customer findByName(String c);
}
