package com.lpu.demo_security1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Hiii";
	}
	
	@GetMapping("/home")
	public String home() {
		return "HomePage";
	}
	
	@GetMapping("/reg")
	public String register() {
		return "register";
	}
}
