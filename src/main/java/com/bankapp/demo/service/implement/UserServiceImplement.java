package com.bankapp.demo.service.implement;



import com.bankapp.demo.dto.AccountDetailsDto;
import com.bankapp.demo.dto.UserDetailsDto;
import com.bankapp.demo.entity.User;
import com.bankapp.demo.exception.UserNotFoundException;

public interface UserServiceImplement {

	public String addNewUserDetails(UserDetailsDto userDetailsDto) throws UserNotFoundException;
	
	public AccountDetailsDto getAccountDetails(Long mobileNumber);

	//public AccountDetailsDto getAccountDetails(String mobileNumber);
	
	public Boolean getMobileDetails(String mobileNumber);
}
