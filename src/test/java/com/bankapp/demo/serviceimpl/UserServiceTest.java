package com.bankapp.demo.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bankapp.demo.dto.AccountDetailsDto;
import com.bankapp.demo.dto.UserDetailsDto;
import com.bankapp.demo.entity.Account;
import com.bankapp.demo.entity.User;
import com.bankapp.demo.exception.AccountNumberNotFoundException;
import com.bankapp.demo.exception.UserNotFoundException;
import com.bankapp.demo.repository.AccountRepository;
import com.bankapp.demo.repository.TransferRepository;
import com.bankapp.demo.repository.UserRepository;
import com.bankapp.demo.service.UserService;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	UserDetailsDto userDetailsDto;
	
	@Mock
	TransferRepository transferRepository;
	
	@Test
	public void testAddNewUserDetails(){
		User user = new User();
		user.setPanNumber("DS45GH3561");
		user.setFirstName("Abhilash");
	//	user.setUserId(1);
		//user.setMobileNumber("9966512485");
		
		Mockito.when(userRepository.findByPanNumber(Mockito.anyString())).thenReturn(user);
		
		
		try {
			String response = userService.addNewUserDetails(userDetailsDto);
			
			assertNotNull(response);
			assertEquals("customer registered successfully", response);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assertNotNull(response);
	//	assertEquals("DS45GH3561", response);
	}
	
	@Test
	public void testAddNewUserDetailsForException() {
		User user = new User();
		user.setPanNumber("DS45GH3561");
		user.setFirstName("Abhilash");
		//user.setUserId(1);
		//user.setMobileNumber("9966512485");
		userDetailsDto= null;
		
		try {
			Mockito.when(userRepository.findByPanNumber("GF52NB4512")).thenReturn(user);
			String response = userService.addNewUserDetails(userDetailsDto);
			assertTrue(false);
		}catch(UserNotFoundException user1) {
			assertTrue(true);
		//assertNotNull(response);
		//assertEquals("DS45GH3561", panUser.getPanNumber());
		}
	}
	
	@Test
	public void testGetAccountDetails() {
		Account account = new Account();
		AccountDetailsDto accountDetailsDto=new AccountDetailsDto();
		account.setAccountNumber(1L);
		account.setCurrentBalance(1D);
		
		Mockito.when(accountRepository.findByAccountNumber(Mockito.anyLong())).thenReturn(Optional.of(account));
		
		AccountDetailsDto accNum = userService.getAccountDetails(1L);
		
		assertNotNull(accNum);
		assertEquals(1L, accNum.getAccountNumber());
	}
	
	@Test
	public void testGetAccountDetailsForException(){
		Account account = new Account();
	//	AccountDetailsDto accountDetailsDto=new AccountDetailsDto();
		account.setAccountNumber(1L);
		account.setCurrentBalance(1D);
		
		Mockito.when(accountRepository.findByAccountNumber(1L)).thenReturn(Optional.of(account));
		
		try {
			
			AccountDetailsDto accNum = userService.getAccountDetails(2L);
			assertTrue(false);
		} catch (Exception acc) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetMobileDetails() {
		User user = new User();
		user.setMobileNumber("9966512485");
		
		Mockito.when(userRepository.findByMobileNumber("9966512485")).thenReturn(Optional.of(user));
		
		Boolean mobile = userService.getMobileDetails("9966512485");
		//System.out.println(mobile);
		assertNotNull(mobile);
		assertEquals(true, mobile);
		
	}
}
