package com.lpu.mobileApp.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class MobileRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String brandName;

	@NotBlank
	private String modelName;

	
	private double price;

	@NotBlank
	private String ram;

	@NotBlank
	private String storage;
	
	@NotBlank
	private String color;

	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
