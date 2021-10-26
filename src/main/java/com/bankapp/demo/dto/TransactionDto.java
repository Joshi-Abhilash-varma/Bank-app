package com.bankapp.demo.dto;

import javax.validation.constraints.NotNull;

public class TransactionDto {
	
	@NotNull(message="please enter fromAccount")
	private long fromAccount;
	
	@NotNull(message="please enter toAccount")
	private long toAccount;
	
	@NotNull(message="please enter amount")
	private Double amount;
	
	private String description;

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
