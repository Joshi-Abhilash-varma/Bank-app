package com.bankapp.demo.dto;



import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.bankapp.demo.entity.Account;


public class UserDetailsDto {
	
	@NotEmpty(message = "firstName should not be empty")
	@Size(min= 3, max = 10, message = "firstName should be less than 20 characters only")
	private String firstName;
	
	@NotEmpty(message = "lastName should not be empty")
	@Size(min= 3, max = 10, message = "firstName should be less than 20 characters only")
	private String lastName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "please mention date")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message = "panNumber should not be empty")
	@Size(min = 8, max = 10,message = " pannumber should less then 10 character only")
	private String panNumber;
	
	@NotEmpty(message = "Please provide a Mobile Number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Provide valid Mobile Number")
	@Size(min = 5, max = 10, message = "phone number is of 10 digits")
	private String mobileNumber;
	
	@NotEmpty(message = "emailId should not be empty")
	@Email
	@Size(min = 5, max = 25,message = "EmailId size should should be 25 characterstics only")
	private String emailId;
	
	@NotEmpty(message = "gender should not be empty")
	@Size(min = 1, max = 10,message = "gender should by 10 character only")
	private String gender;
	
	//private Account accountDetails;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*public Account getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(Account accountDetails) {
		this.accountDetails = accountDetails;
	} */
	

}
