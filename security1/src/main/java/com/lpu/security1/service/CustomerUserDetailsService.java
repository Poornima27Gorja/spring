package com.lpu.security1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.security1.entity.Customer;
import com.lpu.security1.repository.CustomerRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepo cr;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer c = cr.findByName(username);
		return new CustomerUserDetails(c);
	}
}
