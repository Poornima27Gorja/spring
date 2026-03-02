package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lpu")
@RestController
public class LpuController {
	
	@RequestMapping("college")
	public String saveCollege() {
		return "College saved";
	}
	
	@PostMapping("/student")
	public String saveStudent() {
		return "Student saved";
	}
	
	@PostMapping("/trainer")
	public String saveTrainer() {
		return "Trainer saved";
	}
	
	@PostMapping("/security")
	public String saveSecurity() {
		return "Security saved";
	}
}
