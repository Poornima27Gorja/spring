package com.lpu.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.account.entity.Account;
import com.lpu.account.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	public Account addAccount(Account account) {
		return repository.save(account);
	}
	
	public Account findAccount(int accountId) {
		return repository.findById(accountId).orElse(null);
	}
	
	 public List<Account> findAccounts() {
		 return repository.findAll();
	 }
	 
	 public Account updateAccount(int accountId, Account account) {
		 Account a = repository.findById(accountId).orElse(null);
		 
		 a.setName(account.getName());
		 a.setAccountType(account.getAccountType());
		 
		 return repository.save(a);
	 }
	 
	 public void deleteAccount(int accountId) {
		 repository.deleteById(accountId);
	 }
}
