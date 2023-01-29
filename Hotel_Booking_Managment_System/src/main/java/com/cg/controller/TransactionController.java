package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Transactions;
import com.cg.service.ITransactionService;

@RestController
public class TransactionController
{
	@Autowired
	private ITransactionService itransactionservice;
	
	@PostMapping("/addtransaction")
	public String addpayment(@RequestBody Transactions transaction) {
		return itransactionservice.addtransaction(transaction);

	}
	

}
