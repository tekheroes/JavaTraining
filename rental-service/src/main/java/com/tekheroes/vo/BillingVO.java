package com.tekheroes.vo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class BillingVO {
	private LocalDate hireDate;
	private int days;
	private int custId;
	private String regNo;
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	
}
