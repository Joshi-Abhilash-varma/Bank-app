package com.bankapp.demo.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.bankapp.demo.entity.User;



public class AccountDetailsDto {
	
	@Digits(integer = 8, fraction = 1, message = "InValid accountNumber")
	private long accountNumber;
	
	@NotEmpty(message = "ifsccode should not be empty")
	@Size(min = 8, max = 20,message = " ifsccode should less then 20 character only")
	private String ifsccode;
	
/*	@NotEmpty(message = "balance should not be empty")
	@NotNull(message = "please provide valid balance")
	@Size(min = 5, max = 10, message = "please provide valid balance")
	private Double openingBalance;*/
	
	private Double currentBalance;
	//private long customerId;
	private String accountType;
	
	private String branchAddress;
	
	private User userDetails;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	/*public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}*/

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	

}
