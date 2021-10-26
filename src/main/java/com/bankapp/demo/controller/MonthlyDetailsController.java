package com.bankapp.demo.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.demo.entity.Transaction;
import com.bankapp.demo.service.implement.MonthlyStatementServiceImplement;

@Validated
@RestController
@RequestMapping("/monthlydetails")
public class MonthlyDetailsController {
	
	@Autowired
	public MonthlyStatementServiceImplement monthlyStatementServiceImplement;
	
	@GetMapping("/{fromAccount}/{year}/{month}")
	public List<Transaction> getMiniStatement(@Valid @PathVariable("fromAccount")  long fromAccount,
								@PathVariable("year") String year,@PathVariable("month") String month) throws ParseException {
			List<Transaction> statement = monthlyStatementServiceImplement.getMonthlyStatement(fromAccount,year,month);
			return statement;
	}

}
