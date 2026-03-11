package com.lpu.security1.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.security1.entity.Customer;
import com.lpu.security1.repository.CustomerRepo;


@Service
public class CustomerService {
	private final CustomerRepo repo;
	private final PasswordEncoder encoder;

	public CustomerService(CustomerRepo repo, PasswordEncoder encoder) {
		super();
		this.repo = repo;
		this.encoder = encoder;
	}

	public Customer registerCustomer(Customer customer) {
		String epass = encoder.encode(customer.getPassword());
		customer.setPassword(epass);
		return repo.save(customer);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteCustomer(long id) {
		repo.deleteById(id);
	}
	
	@PostAuthorize("returnObject.name == authentication.name")
	public Customer findbyid(long id){
		return repo.findById(id).get();
	}
}
