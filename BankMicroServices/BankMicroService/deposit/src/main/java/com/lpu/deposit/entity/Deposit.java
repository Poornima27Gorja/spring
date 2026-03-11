package com.lpu.deposit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Deposit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depositId;
	
	private String depositType;
	private double depositAmount;
	
	public int getDepositId() {
		return depositId;
	}
	
	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}
	
	public String getDepositType() {
		return depositType;
	}
	
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	
	public double getDepositAmount() {
		return depositAmount;
	}
	
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
}
