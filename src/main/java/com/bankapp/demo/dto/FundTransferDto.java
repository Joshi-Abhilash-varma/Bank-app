package com.bankapp.demo.dto;

import javax.validation.constraints.NotNull;

public class FundTransferDto {
	
	@NotNull(message="please enter fromMobileNumber")
	private String fromMobileNumber;
	
	@NotNull(message="please enter toMobileNumber")
	private String toMobileNumber;
	
	@NotNull(message="please enter amount")
	private Double amount;
	
	private String comments;
	
	

	public FundTransferDto(@NotNull(message = "please enter fromMobileNumber") String fromMobileNumber,
			@NotNull(message = "please enter toMobileNumber") String toMobileNumber,
			@NotNull(message = "please enter amount") Double amount, String comments) {
		super();
		this.fromMobileNumber = fromMobileNumber;
		this.toMobileNumber = toMobileNumber;
		this.amount = amount;
		this.comments = comments;
	}

	public String getFromMobileNumber() {
		return fromMobileNumber;
	}

	public void setFromMobileNumber(String fromMobileNumber) {
		this.fromMobileNumber = fromMobileNumber;
	}

	public String getToMobileNumber() {
		return toMobileNumber;
	}

	public void setToMobileNumber(String toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
