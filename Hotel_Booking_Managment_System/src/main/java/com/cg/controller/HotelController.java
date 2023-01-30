package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Hotel;
import com.cg.service.IHotelService;

import jakarta.validation.Valid;

@RestController
public class HotelController {
	@Autowired
	public IHotelService hotelService;
	
	@PostMapping("/addHotel")
	public String addHotel(@RequestBody @Valid Hotel hotel) {
		return hotelService.addHotel(hotel);
	}
	
	@PutMapping("/updateHotel")
	public Hotel updateHotel(@RequestBody @Valid Hotel hotel) {
		return hotelService.updateHotel(hotel);
	}
	
	@GetMapping("/showAll")
	public List<Hotel>showAllHotels(){
	return hotelService.showAllHotels();
	}
	
	@GetMapping("/showById/{id}")
	public Hotel getHotel(@PathVariable("id") int hotel_id) {
		return hotelService.showHotel(hotel_id);
	}
	
	 @GetMapping("/removeById/{id}")
	 public String removeHotel(@PathVariable("id") int hotel_id){
		  return hotelService.removeHotelById(hotel_id);
	 }
}
