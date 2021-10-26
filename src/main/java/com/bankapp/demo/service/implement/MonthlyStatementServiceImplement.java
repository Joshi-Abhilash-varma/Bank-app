package com.bankapp.demo.service.implement;

import java.text.ParseException;
import java.util.List;

import com.bankapp.demo.dto.MonthlyDetailsDto;
import com.bankapp.demo.entity.Transaction;

public interface MonthlyStatementServiceImplement {
	
	public List<Transaction> getMonthlyStatement(Long accountNumber, String year,String month) throws ParseException;

	public List<Transaction> monthlyStatement(MonthlyDetailsDto statement);

}
