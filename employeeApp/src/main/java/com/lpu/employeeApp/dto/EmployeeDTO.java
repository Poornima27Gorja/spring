package com.lpu.employeeApp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {
	@NotBlank(message = "Name should not be blank")
	private String name;
	@Pattern(regexp = "[7-9][0-9]{9}", message = "Phone number must start with 7, 8 or 9 and contain 10 dights")
	private String phone;
	@Pattern(regexp = "^[a-z0-9_/-]{3,8}@[a-z]{3,}\\.[a-z]{2,3}$", message = "Invalid email format")
	private String email;
	@Min(value = 18, message = "Minimum age should be 18")
	@Max(value = 60, message = "Maximum age should be 60")
	private int age;

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
}
