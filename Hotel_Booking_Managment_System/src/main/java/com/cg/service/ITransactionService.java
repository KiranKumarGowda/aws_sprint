package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Transactions;
import com.cg.repository.ITransactionRepository;

@Service
public class ITransactionService 
{
	@Autowired
	ITransactionRepository itransactionrepository;
	
	public String addtransaction(Transactions transaction) {
		itransactionrepository.saveAndFlush(transaction);
		return "Transactions Done Successfully";
	}
	
}
