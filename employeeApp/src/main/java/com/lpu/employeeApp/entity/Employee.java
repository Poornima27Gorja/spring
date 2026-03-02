package com.lpu.employeeApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "name should not be blank")
	private String name;
	@Positive(message = "phone number should be positive")
	@Pattern(regexp = "[7-9][0-9]{9}", message = "Phone must be 10 digits starting with 7,8,9")
	private String phone;
	@NotBlank(message = "email should not be blank")
	@Email(message = "email should be valid")
	@Pattern(regexp = "[a-z]{2,}@[a-z]{2,}\\.[a-z]{2,3}")
	private String email;
	@Min(value = 18, message = "Age must be above 18")
	@Max(value = 60, message = "Age must be below 60")
	private int age;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Company company;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
