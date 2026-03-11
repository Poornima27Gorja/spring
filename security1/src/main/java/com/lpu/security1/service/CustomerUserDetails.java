package com.lpu.security1.service;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lpu.security1.entity.Customer;

public class CustomerUserDetails implements UserDetails{
	private Customer c;
	
	public CustomerUserDetails(Customer c) {
		super();
		this.c = c;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(c.getRole()));
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return c.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return c.getName();
	}

}
