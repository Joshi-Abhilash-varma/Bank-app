package com.bankapp.demo.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.demo.dto.AccountDetailsDto;
import com.bankapp.demo.dto.UserDetailsDto;


import com.bankapp.demo.service.implement.UserServiceImplement;


@Validated
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImplement userServiceImplement ;
	
	@Autowired
	Environment environment;
	
	
	@PostMapping("/userinfo")	
	public ResponseEntity<String> userRegistration(@Valid @RequestBody UserDetailsDto userDetailsDto) throws Exception
	{
		
		String response= userServiceImplement.addNewUserDetails(userDetailsDto);
		return new ResponseEntity<String>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/userDetails/{mobileNumber}")	
	public Boolean getUserStatus(@PathVariable String mobileNumber) {
		return userServiceImplement.getMobileDetails(mobileNumber);
	}
	
	@GetMapping("/port")
	public String getPortNo() {
		String port = environment.getProperty("local.server.port");
		return "From Bank app : " + port;
	}

}
