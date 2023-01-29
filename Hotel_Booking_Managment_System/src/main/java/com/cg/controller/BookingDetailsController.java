package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.BookingDetails;
import com.cg.service.IBookingDetailsService;

@RestController
public class BookingDetailsController {
	
	@Autowired
	IBookingDetailsService ibookingsdetailsservice;
	
	@PostMapping("/addbookingdetails")
	public String addBookingDetails( @RequestBody BookingDetails bookingdetails) {
		
		return ibookingsdetailsservice.addBookingDetails(bookingdetails);
	}
	
	@PutMapping("/updatebookingdetails")
	public BookingDetails updateBookingDetails(@RequestBody BookingDetails bookingdetails) {
		
		return ibookingsdetailsservice.updateBookingDetails(bookingdetails);
		}
	
	@DeleteMapping("/removeBookingDetails/{id}")
	public String removeBookingDetailsById(@PathVariable("id")int booking_id) {
		
		return ibookingsdetailsservice.removeBookingDetailsById(booking_id);
	}
	
	@GetMapping("/showbookingdetails")
	public List<BookingDetails> showAllBookingDetails(){
		
		return ibookingsdetailsservice.showAllBookingDetails();
	}
	
	@GetMapping("/showbookingdetailsbyid/{id}")
	public BookingDetails showBookingDetailsById(@PathVariable("id") int booking_id) {
		
		return ibookingsdetailsservice.showBookingDetailsById(booking_id);
	}
		
	}
	
}
