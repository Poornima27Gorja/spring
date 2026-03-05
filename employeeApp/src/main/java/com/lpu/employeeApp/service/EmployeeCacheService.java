package com.lpu.employeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.exception.EmployeeNotFoundException;
import com.lpu.employeeApp.repository.EmployeeRepository;

@Service
public class EmployeeCacheService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Cacheable(value = "employee", key = "#id")
	public Employee getEmployeeById(int id) {
		System.out.println("Fetching from DB....");
		return empRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("No employee with id " + id + " found"));
	}
	
	@CachePut(value = "employee", key = "#result.id")
	public Employee addEmployee(Employee newEmployee) {
		return empRepo.save(newEmployee);
	}
	
	@CachePut(value = "employee", key = "#id")
	public Employee updateEmployee(int id, Employee emp) {
		Employee existing = getEmployeeById(id);
		
		existing.setName(emp.getName());
		existing.setPhone(emp.getPhone());
		existing.setEmail(emp.getEmail());
		existing.setAge(emp.getAge());
		
		return existing;
	}
	
	@CacheEvict(value = "employee", key = "#id")
	public void deleteEmployeeById(int id) {
		empRepo.deleteById(id);
	}
}
