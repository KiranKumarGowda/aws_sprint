package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.exceptions.PaymentDetailsNotFoundExcepiton;
import com.cg.exceptions.TransactionNotFoundException;

@ControllerAdvice
public class PaymentExceptionController {
	@ExceptionHandler(value = PaymentDetailsNotFoundExcepiton.class)
	public ResponseEntity<Object> exceptionHandler(Exception ex) 
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=TransactionNotFoundException.class)
	public ResponseEntity<Object> exceptionHandler1(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
