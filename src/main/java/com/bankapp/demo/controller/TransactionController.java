package com.bankapp.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.demo.dto.FundTransferDto;
import com.bankapp.demo.dto.TransactionDto;
import com.bankapp.demo.entity.Transaction;
import com.bankapp.demo.service.implement.TransactionServiceImplement;

@Validated
@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	public TransactionServiceImplement transactionServiceImplement;

	
	@PostMapping("/bankdetails/fundtransfer")
	public List<Transaction> transferMoney(@Valid @RequestBody TransactionDto transactionDto) throws Exception
	{
		
		return transactionServiceImplement.sendMoney(transactionDto);

	}
	
	@PostMapping("/fundtransfer/mobileNumber")
	public Boolean transferMoneyViaMobile(@RequestBody FundTransferDto fundTransferDto ) throws Exception{
		return transactionServiceImplement.sendMoneyByMobileNumbr(fundTransferDto);
	}
	
}
