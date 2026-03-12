package com.lpu.users.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.users.entity.Users;
import com.lpu.users.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Users saveUser(Users user) {
		return repository.save(user);
	}
	
	public Users findUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Users> findAllUsers() {
		return repository.findAll();
	}
	
	public Users updateUserById(int id, Users user) {
		Users u = repository.findById(id).orElse(null);
		
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		
		return repository.save(u);
	}
	
	public void deleteUserById(int id) {
		repository.deleteById(id);
	}
}
