package com.cg.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class BookingDetails {
	
	@Id
	@Min(value=1)
	@NotNull
	private int booking_id;
	
	@NotNull
	private LocalDate booked_from;
	
	@NotNull
	private LocalDate booked_to;
	
	@Min(value=1)
	private int no_of_adults;
	
	private int no_of_children;
	
	@Min(value=600)
	
	private double amount;
	
	@OneToOne
	@JoinColumn(name="userId_fk")
	private User users;
	
	//in user pojo add @onetoOne(mapped by users,cascade all function)create bookind .d object
	
	@OneToOne
	@JoinColumn(name="hotelId_fk")
	private Hotel hotels;
	
	//in hotel pojo add @onetone (mapped by hotel and create book.d object)
	
	@OneToMany
	@JoinColumn(name="paymentId_fk")
	private List<Payments>payments;
	
	//in payment pojo add manytoone 
	
	@OneToMany(mappedBy="bookingdetails",cascade = CascadeType.ALL)
	private List<RoomDetails> roomdetails;
	//in roomdetil pojo add many to one join column name as boolingdetails_fk
	
	public BookingDetails() {}
	public BookingDetails(int booking_id, LocalDate booked_from, LocalDate booked_to, int no_of_adults,
			int no_of_children, double amount, User users, Hotel hotels, List<Payments> payments,
			List<RoomDetails> roomdetails) {
		super();
		this.booking_id = booking_id;
		this.booked_from = booked_from;
		this.booked_to = booked_to;
		this.no_of_adults = no_of_adults;
		this.no_of_children = no_of_children;
		this.amount = amount;
		this.users = users;
		this.hotels = hotels;
		this.payments = payments;
		this.roomdetails = roomdetails;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public LocalDate getBooked_from() {
		return booked_from;
	}
	public void setBooked_from(LocalDate booked_from) {
		this.booked_from = booked_from;
	}
	public LocalDate getBooked_to() {
		return booked_to;
	}
	public void setBooked_to(LocalDate booked_to) {
		this.booked_to = booked_to;
	}
	public int getNo_of_adults() {
		return no_of_adults;
	}
	public void setNo_of_adults(int no_of_adults) {
		this.no_of_adults = no_of_adults;
	}
	public int getNo_of_children() {
		return no_of_children;
	}
	public void setNo_of_children(int no_of_children) {
		this.no_of_children = no_of_children;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Hotel getHotels() {
		return hotels;
	}
	public void setHotels(Hotel hotels) {
		this.hotels = hotels;
	}
	public List<Payments> getPayments() {
		return payments;
	}
	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}
	public List<RoomDetails> getRoomdetails() {
		return roomdetails;
	}
	public void setRoomdetails(List<RoomDetails> roomdetails) {
		this.roomdetails = roomdetails;
	}
	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", booked_from=" + booked_from + ", booked_to=" + booked_to
				+ ", no_of_adults=" + no_of_adults + ", no_of_children=" + no_of_children + ", amount=" + amount + "]";
	}
	
	
}
