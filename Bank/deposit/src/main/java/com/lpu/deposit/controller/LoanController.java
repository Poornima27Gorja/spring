package com.lpu.deposit.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit")
public class LoanController {
	@GetMapping("/save")
	public String save() {
		return "saved the deposit";
	}
	
	
	@GetMapping("/get")
	public String get() {
		return "u get it";
	}
}
