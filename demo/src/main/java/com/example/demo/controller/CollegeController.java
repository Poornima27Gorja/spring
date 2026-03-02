package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.College;
import com.example.demo.entity.Student;
import com.example.demo.service.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;

	@PostMapping("/clg")
	public College saveCollege(@RequestBody College clg) {
		return service.saveCollege(clg);
	}
	
	@PostMapping("/clg/{clg_id}/student")
	public void addSToCld(@PathVariable int clg_id, @RequestBody Student student) {
		service.addStudentToClgById(clg_id, student);
	}
}
