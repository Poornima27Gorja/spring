package com.lpu.employeeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.exception.CompanyNotFoundException;
import com.lpu.employeeApp.exception.NoDataFoundException;
import com.lpu.employeeApp.repository.CompanyRepository;
import com.lpu.employeeApp.repository.EmployeeRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository cmpRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public Company saveCompany(Company company) {
		return cmpRepo.save(company);
	}
	
	public List<Company> saveCompanies(List<Company> companies) {
		return cmpRepo.saveAll(companies);
	}
	
	public Company saveCompanyAndMapWithEmployee(Company company) {
		company.getEmployees().forEach((employee) -> employee.setCompany(company));
		return cmpRepo.save(company);
	}
	
	public Company saveEmployeesToExistingCompany(int companyId, List<Employee> newEmp) {
		Company company = cmpRepo.findById(companyId).orElse(null);
		newEmp.forEach((employee) -> employee.setCompany(company));
		company.getEmployees().addAll(newEmp);
		return cmpRepo.save(company);
	}
	
	public Company mapEmpIdWithCmpId(int empId, int cmpId) {
		Company company = cmpRepo.findById(cmpId).orElse(null);
		Employee employee = empRepo.findById(empId).orElse(null);

	    employee.setCompany(company);
	    
	    company.getEmployees().add(employee);

	    empRepo.save(employee);

	    return company;
	}
	
	public int handleExcep(int a, int b) {
		return a/b;
	}
	
	public Company findCompanyById(int id) {
		return cmpRepo.findById(id).orElseThrow(
				() -> new CompanyNotFoundException("Company with id " + id + " doesn't exist"));
	}
	
	public List<Company> findAllCompanies() {
		List<Company> cmpList = cmpRepo.findAll();
		
		if(cmpList.isEmpty()) {
			throw new NoDataFoundException("No data found");
		}
		
		return cmpList;
	}
	
	public void deleteCompanyById(int id) {
		Company company = cmpRepo.findById(id).orElseThrow(
				() -> new CompanyNotFoundException("Company with id " + id + " doesn't exist, so couldn't delete"));
		cmpRepo.delete(company);
	}
	
	public void deleteAllComapnies() {
		cmpRepo.deleteAll();
	}
}
