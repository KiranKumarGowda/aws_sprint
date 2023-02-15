package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.RoomDetails;
import com.cg.exceptions.RoomDetailsNotFoundException;
import com.cg.exceptions.Room_IDNotFoundException;
import com.cg.repository.IRoomDetailsRepository;

@Service
public class IRoomDetailsService {
	@Autowired
	public IRoomDetailsRepository iroomdetailsRepository;

	public String addRoomDetails(RoomDetails roomDetails) {
		iroomdetailsRepository.saveAndFlush(roomDetails);
	  	return "Room Added Successfully";
	 }

	public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
		if(!iroomdetailsRepository.existsById(roomDetails.getRoom_id())) {
			
		
			throw new RoomDetailsNotFoundException("RoomDetails not found");
	
		}else {
			RoomDetails room_details=iroomdetailsRepository.findById(roomDetails.getRoom_id()).get();
			  room_details.setRoom_id(roomDetails.getRoom_id());
			  room_details.setRoom_no(roomDetails.getRoom_no());
			  room_details.setRoom_type(roomDetails.getRoom_type());
			  room_details.setRate_per_day(roomDetails.getRate_per_day());
			//  room_details.setIsavailable(roomDetails.getIsavailable());
			  iroomdetailsRepository.save(room_details);
			  
			  return room_details;
			
			
		}
		
	 }

	public List<RoomDetails> showAllRoomdetails() {
		return iroomdetailsRepository.findAll();
	 }
	
	public RoomDetails showRoomdetails(int room_id) {
		return iroomdetailsRepository.findById(room_id).get();
	}
	
	public String removeRoomDetailsById(int room_id) {
		if(iroomdetailsRepository.existsById(room_id))
		 {iroomdetailsRepository.deleteById(room_id);
		return "Roomdetails are removed successfully";}
		else {throw new Room_IDNotFoundException("Roomdetails are not found with room_Id:"+room_id);}}
}
