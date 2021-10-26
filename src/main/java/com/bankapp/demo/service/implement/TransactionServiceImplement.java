package com.bankapp.demo.service.implement;

import java.util.List;

import com.bankapp.demo.dto.FundTransferDto;
import com.bankapp.demo.dto.TransactionDto;
import com.bankapp.demo.entity.Transaction;
import com.bankapp.demo.exception.FromAccountNumberNotFoundException;
import com.bankapp.demo.exception.InavalidAccountException;
import com.bankapp.demo.exception.InsufficientBalanceException;
import com.bankapp.demo.exception.ToAccountNumberNotFoundException;

public interface TransactionServiceImplement {
	
	public List<Transaction> sendMoney(TransactionDto transactionDto) throws InsufficientBalanceException, FromAccountNumberNotFoundException, ToAccountNumberNotFoundException,InavalidAccountException;

	//public Boolean transferByMobileNumber(String mobileNumber);
	
	public Boolean sendMoneyByMobileNumbr(FundTransferDto fundTransfer) throws InsufficientBalanceException, FromAccountNumberNotFoundException, ToAccountNumberNotFoundException, InavalidAccountException;
}
