package com.bankapp.demo.service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.demo.dto.FundTransferDto;
import com.bankapp.demo.dto.TransactionDto;
import com.bankapp.demo.entity.Account;

import com.bankapp.demo.entity.Transaction;
import com.bankapp.demo.entity.User;
import com.bankapp.demo.exception.FromAccountNumberNotFoundException;
import com.bankapp.demo.exception.InavalidAccountException;
import com.bankapp.demo.exception.InsufficientBalanceException;
import com.bankapp.demo.exception.ToAccountNumberNotFoundException;
import com.bankapp.demo.repository.AccountRepository;
import com.bankapp.demo.repository.TransferRepository;
import com.bankapp.demo.repository.UserRepository;
import com.bankapp.demo.service.implement.TransactionServiceImplement;

@Service
public class TransactionService implements TransactionServiceImplement {

	@Autowired
	public AccountRepository accountRepository;
	@Autowired
	public TransferRepository transferRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public List<Transaction> sendMoney(TransactionDto transactionDto) throws InsufficientBalanceException, FromAccountNumberNotFoundException, ToAccountNumberNotFoundException, InavalidAccountException {
		Transaction sourceAcc= new Transaction();
		Transaction targetAcc= new Transaction();
		List<Transaction> listTransHistroy=new ArrayList<Transaction>();
		 java.util.Date date=new java.util.Date();
         long time=date.getTime();
         Timestamp ts=new Timestamp(time);

         		Optional<Account> fromacc = accountRepository.findByAccountNumber(transactionDto.getFromAccount());
         		if (fromacc.isPresent()) {
         			Optional<Account> toacc = accountRepository.findByAccountNumber(transactionDto.getToAccount());
         				if (toacc.isPresent()) {
         						long fromAccountNumber = transactionDto.getFromAccount();
         						long toAccountNumber = transactionDto.getToAccount();
         					if(fromAccountNumber==toAccountNumber)
         							throw new InavalidAccountException("from and to accountnumber is same");
         					Account fromAccount = fromacc.get();
         					Account toAccount = toacc.get();
        
         		if (fromAccount.getCurrentBalance() >= transactionDto.getAmount()) {
         			double fromaccbal=fromAccount.getCurrentBalance() - transactionDto.getAmount();
         			double toAccbal=toAccount.getCurrentBalance() + transactionDto.getAmount();
         			fromAccount.setCurrentBalance((fromAccount.getCurrentBalance() - transactionDto.getAmount()));
         			sourceAcc.setToAccount(transactionDto.getToAccount());
         			sourceAcc.setAccountNumber(fromAccountNumber);
         			sourceAcc.setAmount(transactionDto.getAmount());
         			sourceAcc.setCurrentBalance(fromaccbal);
         			sourceAcc.setCredit_debit("debit");
         			sourceAcc.setDescription(transactionDto.getDescription());
         			sourceAcc.setTransactionDate(ts);
         			accountRepository.save(fromAccount);
         			Transaction transaction1= transferRepo.save(sourceAcc);
         			toAccount.setCurrentBalance((toAccount.getCurrentBalance() + transactionDto.getAmount()));
         			
         			targetAcc.setAccountNumber(transactionDto.getToAccount());
         			//System.out.println(transactionDto.getToAccount());
         			targetAcc.setToAccount(transactionDto.getFromAccount());
         		//	targetAcc.setToAccount(fromAccountNumber);
         			targetAcc.setAmount(transactionDto.getAmount());
         			targetAcc.setCurrentBalance(toAccbal);
         			targetAcc.setCredit_debit("credit");
         			targetAcc.setDescription(transactionDto.getDescription());
         			targetAcc.setTransactionDate(ts);
         			accountRepository.save(toAccount);
         			Transaction transaction2= transferRepo.save(targetAcc);
         			listTransHistroy.add(transaction1);
         			listTransHistroy.add(transaction2);
         		}
         		else {
         			throw new InsufficientBalanceException("Insufficiant Amount !!!!");
         		}

         	} else {
         			throw new InsufficientBalanceException("To Account number Not found");
         	}
    } else {
			throw new FromAccountNumberNotFoundException("From Account Number Not Found");
}
		return listTransHistroy;

}
/*	@Override
	public Boolean transferByMobileNumber(String mobileNumber) {
		User user = transferRepo.transferByMobileNumber(mobileNumber);
		return 
	}*/

	@Override
	public Boolean sendMoneyByMobileNumbr(FundTransferDto fundTransfer) throws InsufficientBalanceException, FromAccountNumberNotFoundException, ToAccountNumberNotFoundException, InavalidAccountException{
		Optional<User >fromUser = userRepository.findByMobileNumber(fundTransfer.getFromMobileNumber());
		System.out.println("fromUser"+" "+fromUser);
		Optional<User >toUser = userRepository.findByMobileNumber(fundTransfer.getToMobileNumber());
		System.out.println("toUser"+" "+toUser);

		Boolean result = false;
		Transaction sourceAcc= new Transaction();
		Transaction targetAcc= new Transaction();
		List<Transaction> listTransHistroy=new ArrayList<Transaction>();
		java.util.Date date=new java.util.Date();
         long time=date.getTime();
         Timestamp ts=new Timestamp(time);

         		Optional<Account> fromacc = accountRepository.findByUserDetails(fromUser.get());
         		System.out.println("fromacc"+" "+fromacc);
         		if (fromacc.isPresent()) {
         			long fromAccountNumber = fromacc.get().getAccountNumber();
 					System.out.println("fromAccountNumber "+fromAccountNumber);

         			Optional<Account> toacc = accountRepository.findByUserDetails(toUser.get());
         				if (toacc.isPresent()) { 
         							long toAccountNumber = toacc.get().getAccountNumber();
         					System.out.println("toAccountNumber "+toAccountNumber);
         				if(fromAccountNumber==toAccountNumber)
         							throw new InavalidAccountException("from and to accountnumber is same");
         					Account fromAccount = fromacc.get();
         					System.out.println("fromAccount "+fromAccount);
         					Account toAccount = toacc.get();
         					System.out.println("toAccount "+toAccount);

        
         		if (fromAccount.getCurrentBalance() >= fundTransfer.getAmount()) {
         			double fromaccbal=fromAccount.getCurrentBalance() - fundTransfer.getAmount();
         			double toAccbal=toAccount.getCurrentBalance() + fundTransfer.getAmount();
         			fromAccount.setCurrentBalance((fromAccount.getCurrentBalance() - fundTransfer.getAmount()));
         			sourceAcc.setToAccount(toAccountNumber);
         			sourceAcc.setAccountNumber(fromAccountNumber);
         			sourceAcc.setAmount(fundTransfer.getAmount());
         			sourceAcc.setCurrentBalance(fromaccbal);
         			sourceAcc.setCredit_debit("debit");
         			sourceAcc.setDescription(fundTransfer.getComments());
         			sourceAcc.setTransactionDate(ts);
         			accountRepository.save(fromAccount);
         			Transaction transaction1= transferRepo.save(sourceAcc);
         			toAccount.setCurrentBalance((toAccount.getCurrentBalance() + fundTransfer.getAmount()));
         			
         			targetAcc.setAccountNumber(toAccountNumber);
         			//System.out.println(transactionDto.getToAccount());
         			targetAcc.setToAccount(fromAccountNumber);
         		//	targetAcc.setToAccount(fromAccountNumber);
         			targetAcc.setAmount(fundTransfer.getAmount());
         			targetAcc.setCurrentBalance(toAccbal);
         			targetAcc.setCredit_debit("credit");
         			targetAcc.setDescription(fundTransfer.getComments());
         			targetAcc.setTransactionDate(ts);
         			accountRepository.save(toAccount);
         			Transaction transaction2= transferRepo.save(targetAcc);
         			listTransHistroy.add(transaction1);
         			listTransHistroy.add(transaction2);
         			
         			result = true;
         		}
         		else {
         			throw new InsufficientBalanceException("Insufficiant Amount !!!!");	
         			
         		}

         	} else {
         			throw new InsufficientBalanceException("To Account number Not found");
			
         	}
         	} else {
			throw new FromAccountNumberNotFoundException("From Account Number Not Found");
			
			
    		}
		
         		return result;
	}
	

	
}
