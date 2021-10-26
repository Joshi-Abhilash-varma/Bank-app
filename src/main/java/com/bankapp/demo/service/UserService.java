package com.bankapp.demo.service;


import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.demo.dto.AccountDetailsDto;
import com.bankapp.demo.dto.UserDetailsDto;
import com.bankapp.demo.entity.Account;
import com.bankapp.demo.entity.User;
import com.bankapp.demo.exception.UserNotFoundException;
import com.bankapp.demo.repository.AccountRepository;
import com.bankapp.demo.repository.TransferRepository;
import com.bankapp.demo.repository.UserRepository;
import com.bankapp.demo.service.implement.UserServiceImplement;

@Service
public class UserService implements UserServiceImplement{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransferRepository transferRepository;
	
	@Override
	public String addNewUserDetails(UserDetailsDto userDetailsDto) throws UserNotFoundException{
		User newUserDetails=new User();
		Account account=new Account();
		//if(userDetailsDto ==null) {
			
		
		if(userDetailsDto!=null)
		{
			
			User panDetails = userRepository.findByPanNumber(userDetailsDto.getPanNumber());
			BeanUtils.copyProperties(userDetailsDto, newUserDetails);
			if(panDetails==null)
			{
				BeanUtils.copyProperties(userDetailsDto, newUserDetails);
				userRepository.save(newUserDetails);
				AccountDetailsDto accDetailsDto=new AccountDetailsDto();
				accDetailsDto.setAccountNumber(accNoGeneration());
				accDetailsDto.setAccountType("saving");
				accDetailsDto.setIfsccode("icici1044");
				accDetailsDto.setBranchAddress("hyd");
				//accDetailsDto.setOpeningBalance(10000.00);
				accDetailsDto.setCurrentBalance(10000.00);
				accDetailsDto.setUserDetails(newUserDetails);
				BeanUtils.copyProperties(accDetailsDto, account);
				accountRepository.save(account);
			}
			
			
			else if(newUserDetails.getPanNumber().equalsIgnoreCase(panDetails.getPanNumber()))
			{
				
				//return "customer allready existing";

				throw new NullPointerException("customer allready existing");

			}else if(!(newUserDetails.getPanNumber().equalsIgnoreCase(panDetails.getPanNumber())))
			{
				BeanUtils.copyProperties(userDetailsDto, newUserDetails);
				userRepository.save(newUserDetails);
				AccountDetailsDto accDetailsDto=new AccountDetailsDto();
				accDetailsDto.setAccountNumber(accNoGeneration());
				accDetailsDto.setAccountType("saving");
				accDetailsDto.setIfsccode("icici1044");
				accDetailsDto.setBranchAddress("hyd");
				//accDetailsDto.setOpeningBalance(10000.00);
				accDetailsDto.setCurrentBalance(10000.00);
				accDetailsDto.setUserDetails(newUserDetails);
				BeanUtils.copyProperties(accDetailsDto, account);
				accountRepository.save(account);
			}
			
		}
		else
		{
			throw new UserNotFoundException("customer doesn't have valid input data");
		}
		
		return "customer registered successfully";
	}		
//}

	public static int accNoGeneration() {
		int n=9;
	    int m = (int) Math.pow(10, n - 1);
	    return m + new Random().nextInt(9 * m);
	}
	
	@Override
	public AccountDetailsDto getAccountDetails(Long accountNumber)  {
		// TODO Auto-generated method stub
		AccountDetailsDto accountDetailsDto=new AccountDetailsDto();
		//accountDetailsDto=bankAccdetails.findByAccountNumber(accountNo);
		Optional<Account> account= accountRepository.findByAccountNumber(accountNumber);
		if(account.isPresent())
		{
		
		Account acc=account.get();
		accountDetailsDto.setAccountNumber(acc.getAccountNumber());
		accountDetailsDto.setCurrentBalance(acc.getCurrentBalance());
		return accountDetailsDto; 

		}
	
		return null;
	}

	@Override
	public Boolean getMobileDetails(String mobileNumber) {
		Optional<User> user =  userRepository.findByMobileNumber(mobileNumber);
		if(user.isPresent()) {
			return true;
		}else {
			return false;
		}
	}
	
}
