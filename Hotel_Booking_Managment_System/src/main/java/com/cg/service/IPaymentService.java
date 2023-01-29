package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Payments;
import com.cg.repository.IPaymentRepository;

@Service
public class IPaymentService {
	@Autowired
	IPaymentRepository ipaymentrepository;

	public String addpayment(Payments payment) {
		ipaymentrepository.saveAndFlush(payment);
		return "Payment Done Successfully";
	}

}