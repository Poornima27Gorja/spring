package com.lpu.security1.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.security1.entity.Customer;
import com.lpu.security1.service.CustomerService;

@RestController
public class CustomerController {

	private final CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return service.registerCustomer(customer);
	}
	
	@GetMapping("/public")
	public String homePage() {
		return "Public Page";
	}
	
	@GetMapping("/account")
	public String accountPage() {
		return "Account Page";
	}
	@GetMapping("/findbyid/{id}")
	public Customer findByid(@PathVariable long id) {
		return service.findbyid(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {
		service.deleteCustomer(id);
		return "deleted";
	}
	
	@GetMapping("/csrf")
	public CsrfToken csrf(CsrfToken t) {
		return t;
	}
	
	@GetMapping("/save")
	public String save() {
		return "save";
	}
}