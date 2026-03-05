package com.lpu.employeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.employeeApp.dto.EmployeeDTO;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.EmployeeCacheService;
import com.lpu.employeeApp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	 
	@Autowired
	private EmployeeCacheService empCSer; 
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO> saveEmp(@Valid @RequestBody EmployeeDTO employeedto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(empServ.saveEmployee(employeedto));
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return empServ.findEmployeeById(id);
	}
	
	@GetMapping("/emp/{id}")
	public Employee findEmploById(@PathVariable int id) {
		return empCSer.getEmployeeById(id);
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees(){
		return empServ.findAllEmployees();
	}
}
