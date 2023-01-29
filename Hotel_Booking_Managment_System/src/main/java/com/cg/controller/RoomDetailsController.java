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

import com.cg.entity.RoomDetails;
import com.cg.service.IRoomDetailsService;


@RestController
public class RoomDetailsController {

	@Autowired
	private  IRoomDetailsService iroomdetailsservice;	
	
	@PostMapping("/addroomDetails") 	
	public String addRoomDetails(@RequestBody RoomDetails roomDetails) 
	{
		return iroomdetailsservice.addRoomDetails(roomDetails);
	}
	@PutMapping("/update")
	public RoomDetails updateRoomDetails(@RequestBody RoomDetails roomDetails) {
		return iroomdetailsservice.updateRoomDetails(roomDetails);
	}
	
	@GetMapping("/getAll")
	public List<RoomDetails> getAll(){
		return iroomdetailsservice.showAllRoomdetails();
	}
	
	@GetMapping("/getById/{id}")
	public RoomDetails getRoomDetails(@PathVariable("id") int room_id) {
		return iroomdetailsservice.showRoomdetails(room_id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteRoomDetails(@PathVariable("id") int room_id) {
		return iroomdetailsservice.removeRoomDetailsById(room_id);
	}
}