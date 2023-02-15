package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.BookingDetails;
import com.cg.exceptions.BookingDetailsNotFoundException;
import com.cg.exceptions.BookingIdNotFoundException;
import com.cg.repository.IBookingDetailsRepository;

@Service
public class IBookingDetailsService {
	
	@Autowired
	public IBookingDetailsRepository ibookingdetailsrepository;
	
	public String addBookingDetails(BookingDetails bookingdetails) {
		ibookingdetailsrepository.saveAndFlush(bookingdetails);
		
		return "BookingDetails Added Successfully";
	}
	
	public BookingDetails updateBookingDetails(BookingDetails bookingdetails) {
		if(!ibookingdetailsrepository.existsById(bookingdetails.getBooking_id())) {
			throw new BookingDetailsNotFoundException("BookingDetails Not Found");
		}
		
		else {
			 BookingDetails booking_details=ibookingdetailsrepository.findById(bookingdetails.getBooking_id()).get();
			 booking_details.setBooked_to(bookingdetails.getBooked_to());
			 booking_details.setBooked_from(bookingdetails.getBooked_from());
			 booking_details.setNo_of_adults(bookingdetails.getNo_of_adults());
			 booking_details.setNo_of_children(bookingdetails.getNo_of_children());
			 booking_details.setAmount(bookingdetails.getAmount());
			 
			 ibookingdetailsrepository.save(booking_details);
			
			 return booking_details;
		}
		
	}
	
	public String removeBookingDetailsById(int booking_id) {

		if(ibookingdetailsrepository.existsById(booking_id)) {
			ibookingdetailsrepository.deleteById(booking_id);
		return "Bookingdetails are removed successfully";
		}
		else {
		throw new BookingIdNotFoundException("Booking details are not found with Booking_Id:"+booking_id);
		}
		}
	
	public List<BookingDetails> showAllBookingDetails() {
		
		return ibookingdetailsrepository.findAll();
		}
	
	
	public BookingDetails showBookingDetailsById(int booking_id) {
		
		Optional<BookingDetails> bd= ibookingdetailsrepository.findById(booking_id);
		if(bd.isPresent()) {
		return bd.get();
		}
		else {
		throw new BookingDetailsNotFoundException(" Booking details not found with Booking_Id:"+booking_id);
		}
		}

	


}
