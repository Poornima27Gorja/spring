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

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.CompanyService;

import jakarta.validation.Valid;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService cmpServ;
	
	@PostMapping("/company")
	public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company company) {
		Company cmpBody = cmpServ.saveCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(cmpBody);
	}
	
	@PostMapping("/company2")
	public Company saveCompanyWithMapping(@Valid @RequestBody Company company) {
		return cmpServ.saveCompanyAndMapWithEmployee(company);
	}
	
	@PostMapping("/company/{companyId}")
	public Company saveEmployeeToComapany(@PathVariable int companyId, @RequestBody List<Employee> newEmp) {
		return cmpServ.saveEmployeesToExistingCompany(companyId, newEmp);
	}
	
	@GetMapping("/company/map/{empId}/{cmpId}")
	public Company mapEmployeeIdWthCompanyId(@PathVariable int empId, @PathVariable int cmpId) {
		return cmpServ.mapEmpIdWithCmpId(empId, cmpId);
	}
	
	@GetMapping("/company/{a}/{b}")
	public int handleDivisinException(@PathVariable int a, @PathVariable int b) {
		return cmpServ.handleExcep(a, b);
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> findCompanyById(@PathVariable int id) {
		Company cmpBody = cmpServ.findCompanyById(id);
		return ResponseEntity.ok(cmpBody);
	}
}
