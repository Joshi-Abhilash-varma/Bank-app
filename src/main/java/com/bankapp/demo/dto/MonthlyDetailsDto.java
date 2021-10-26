package com.bankapp.demo.dto;

import javax.validation.constraints.NotNull;

public class MonthlyDetailsDto {
	
	private Long accountNumber;
	
	@NotNull(message = "please provide valid month")
	private int month;
	
	@NotNull(message = "please provide valid year")
	private int year;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() { 
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
