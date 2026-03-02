package com.lpu.employeeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.dto.EmployeeDTO;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.exception.EmployeeNotFoundException;
import com.lpu.employeeApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	
	public EmployeeDTO saveEmployee(Employee emp) {
		return empToDTO(emprepo.save(emp));
	}
	
	public EmployeeDTO empToDTO(Employee emp) {
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setName(emp.getName());
		dto.setPhone(emp.getPhone());
		dto.setEmail(emp.getEmail());
		dto.setAge(emp.getAge());
		
		return dto;
	}
	
	public Employee DTOtoEmp(EmployeeDTO dto) {
		Employee emp = new Employee();
		
		emp.setName(dto.getName());
		emp.setPhone(dto.getPhone());
		emp.setEmail(dto.getEmail());
		emp.setAge(dto.getAge());
		
		return emp;
	}
	
	public List<Employee> saveEmployees(List<Employee> employees) {
		return emprepo.saveAll(employees);
	}
	
	public Employee findEmployeeById(int id) {
		return emprepo.findById(id).
				orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " doesn't exist"));
	}
	
	public List<Employee> findAllEmployees() {
		return emprepo.findAll();
	}
	
	public void deleteEmployeeById(int id) {
		emprepo.deleteById(id);
	}
	
	public void deleteAllEmployees() {
		emprepo.deleteAll();
	}
}
