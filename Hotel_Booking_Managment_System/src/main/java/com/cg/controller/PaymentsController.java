package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Payments;
import com.cg.service.IPaymentService;

@RestController
public class PaymentsController {
	@Autowired
	private IPaymentService ipayementservice;

	@PostMapping("/addpayment")
	public String addpayment(@RequestBody Payments payment) {
		return ipayementservice.addpayment(payment);

	}
}
