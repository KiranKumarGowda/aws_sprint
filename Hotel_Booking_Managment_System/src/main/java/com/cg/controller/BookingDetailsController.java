package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.BookingDetails;
import com.cg.service.IBookingDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
@Api(value ="Bookapi")
public class BookingDetailsController {
	
	@Autowired
	IBookingDetailsService ibookingsdetailsservice;
	
	@PostMapping("/addbookingdetails")
	@ApiOperation(value="add new bookingdetails")
	public String addBookingDetails( @RequestBody BookingDetails bookingdetails) {
		
		return ibookingsdetailsservice.addBookingDetails(bookingdetails);
	}
	
	@PutMapping("/updatebookingdetails")
	@ApiOperation(value="update bookingdetails")
	public BookingDetails updateBookingDetails(@RequestBody BookingDetails bookingdetails) {
		
		return ibookingsdetailsservice.updateBookingDetails(bookingdetails);
		}
	
	@DeleteMapping("/removeBookingDetails/{id}")
	public String removeBookingDetailsById(@PathVariable("id")int booking_id) {
		
		return ibookingsdetailsservice.removeBookingDetailsById(booking_id);
	}
	
	@GetMapping("/showbookingdetails")
	@ApiOperation(value="show all bookingdetails")
	public List<BookingDetails> showAllBookingDetails(){
		
		return ibookingsdetailsservice.showAllBookingDetails();
	}
	
	@GetMapping("/showbookingdetailsbyid/{id}")
	@ApiOperation(value="show all bookingdetailsbyid")
	public BookingDetails showBookingDetailsById(@PathVariable("id") int booking_id) {
		
		return ibookingsdetailsservice.showBookingDetailsById(booking_id);
	}
		
	}
	

