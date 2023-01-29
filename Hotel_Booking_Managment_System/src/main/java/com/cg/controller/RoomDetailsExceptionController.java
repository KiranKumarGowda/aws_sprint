package com.cg.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.exceptions.RoomDetailsNotFoundException;
import com.cg.exceptions.Room_IDNotFoundException;
@ControllerAdvice
public class RoomDetailsExceptionController 
{
@ExceptionHandler(value=RoomDetailsNotFoundException.class)
public ResponseEntity<Object> exceptionHandler(Exception ex)
{
return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}
@ExceptionHandler(value=Room_IDNotFoundException.class)
public ResponseEntity<Object> exceptionHandler1(Exception ex)
{
return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}}