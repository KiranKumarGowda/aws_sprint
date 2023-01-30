package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Hotel;
import com.cg.exceptions.HotelIdNotFoundException;
import com.cg.exceptions.HotelNotFoundException;
import com.cg.repository.IHotelRepository;

@Service
public class IHotelService {
	@Autowired
	public IHotelRepository hotelRepository;

	public String addHotel(Hotel hotel) {
	  hotelRepository.saveAndFlush(hotel);
	  	return "Hotel Added Successfully";
	 }

	public Hotel updateHotel(Hotel hotel) {
		if(! hotelRepository.existsById(hotel.getHotel_id())) {
			throw new HotelNotFoundException("Hotel id not found");
	//		Hotel ho=hotelRepository.findById(hotel.getHotel_id()).get();
		}
		else {
			Hotel ho=hotelRepository.findById(hotel.getHotel_id()).get();
			ho.setCity(hotel.getCity());
			ho.setHotel_name(hotel.getHotel_name());
			ho.setAddress(hotel.getAddress());
			ho.setDescription(hotel.getDescription());
			ho.setAvg_rate_per_day(hotel.getAvg_rate_per_day());
			ho.setEmail(hotel.getEmail());
			ho.setPhone1(hotel.getPhone1());
			ho.setPhone2(hotel.getPhone2());
			ho.setWebsite(hotel.getWebsite());
			
			hotelRepository.save(ho);
			System.out.println(ho);
			return ho;
		}
		//return "Hotel Updated Successfully";
	 }

	public List<Hotel> showAllHotels() {
		return hotelRepository.findAll();
	 }
	
	public Hotel showHotel(int id) {
		return hotelRepository.findById(id).get();
	}
	
	public String removeHotelById(int booking_id) {
		if(hotelRepository.existsById(booking_id))
		 {hotelRepository.deleteById(booking_id);
		return "Bookingdetails are removed successfully";}
		else {throw new HotelIdNotFoundException("Booking details are not found with Booking_Id:"+booking_id);}}
}
