package com.cg.entity;

import java.sql.Blob;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class RoomDetails {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private int room_id;
	private int hotel_id;
	private int room_no;
	private String room_type;
	private double rate_per_day;
	private Boolean isavailable;
	private Blob photo;
	
	@ManyToOne
	@JoinColumn(name="BookingDetails_fk")
	private BookingDetails bookingdetails;
     RoomDetails(){}
 
//@OneToMany(cascade=CascadeType.ALL,mappedBy="roomDetails")
   
public int getRoom_id(){
	return room_id;
}
public void setRoom_id(int room_id) {
	this.room_id = room_id;
}
public int getHotel_id() {
	return hotel_id;
}
public void setHotel_id(int hotel_id) {
	this.hotel_id = hotel_id;
}
public int getRoom_no() {
	return room_no;
}
public void setRoom_no(int room_no) {
	this.room_no = room_no;
}
public String getRoom_type() {
	return room_type;
}
public void setRoom_type(String room_type) {
	this.room_type = room_type;
}
public double getRate_per_day() {
	return rate_per_day;
}
public void setRate_per_day(double rate_per_day) {
	this.rate_per_day = rate_per_day;
}
public Boolean getIsavailable() {
	return isavailable;
}
public void setIsavailable(Boolean isavailable) {
	this.isavailable = isavailable;
}
public Blob getPhoto() {
	return photo;
}

public void setPhoto(Blob photo) {
	this.photo = photo;
}

public BookingDetails getBookingdetails() {
	return bookingdetails;
}

public void setBookingdetails(BookingDetails bookingdetails) {
	this.bookingdetails = bookingdetails;
}

@Override
public String toString() {
	return "RoomDetails [room_id=" + room_id + ", hotel_id=" + hotel_id + ", room_no=" + room_no + ", room_type="
			+ room_type + ", rate_per_day=" + rate_per_day + ", isavailable=" + isavailable + ", photo=" + photo + "]";
}
 
}