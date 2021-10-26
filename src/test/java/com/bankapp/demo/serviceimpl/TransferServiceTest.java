package com.bankapp.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bankapp.demo.dto.TransactionDto;
import com.bankapp.demo.entity.Account;
import com.bankapp.demo.entity.Transaction;
import com.bankapp.demo.repository.AccountRepository;
import com.bankapp.demo.repository.TransferRepository;
import com.bankapp.demo.service.TransactionService;

@ExtendWith(SpringExtension.class)
public class TransferServiceTest {
	
	@InjectMocks
	TransactionService transactionService;
	
	@Mock
	TransferRepository transferRepository;
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	TransactionDto transactionDto;
	
	
	@Test
	public void sendMoney() {
		Transaction transfer= new Transaction();
		Account account = new Account();
		transfer.setAccountNumber(1L);
				
		Mockito.when(accountRepository.findByAccountNumber(1L)).thenReturn(Optional.of(account));
		
		//List<Transaction> transactions = transactionService.sendMoney(transactionDto);
		
	}

}
