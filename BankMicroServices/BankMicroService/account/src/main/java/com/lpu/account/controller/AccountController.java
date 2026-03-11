package com.lpu.account.controller;

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

import com.lpu.account.entity.Account;
import com.lpu.account.service.AccountService;

@RequestMapping("/account")
@RestController
public class AccountController {

	@Autowired
	private AccountService service;
	
	@PostMapping("/save")
	public Account saveAccount(@RequestBody Account account) {
		return service.addAccount(account);
	}
	
	@GetMapping("/find/{accountId}")
	public Account findAccountById(@PathVariable int accountId) {
		return service.findAccount(accountId);
	}
	
	@GetMapping("/findAll")
	public List<Account> findAllAccounts() {
		return service.findAccounts();
	}
	
	@PutMapping("/update/{accountId}")
	public Account updateAccountById(@PathVariable int accountId, @RequestBody Account account) {
		return service.updateAccount(accountId, account);
	}
	
	@DeleteMapping("/delete/{accountId}")
	public void deleteAccountById(@PathVariable int accountId) {
		service.deleteAccount(accountId);
	}
}
