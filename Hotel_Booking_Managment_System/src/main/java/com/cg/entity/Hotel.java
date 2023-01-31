package com.cg.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hotel_id")
	private int hotel_id;
	@Column(name = "city")
	private String city;

	@Column(name = "hotel_name")
	@NotBlank(message = "Name can not be blank")
	private String hotel_name;

	@Column(name = "address")
	private String address;
	@Column(name = "description")
	private String description;
	@Column(name = "avg_rate_per_day")
	private double avg_rate_per_day;

	@NotBlank(message = "Email is mandatory")
	@Column(name = "email")
	private String email;

	@Column(name = "phone1")
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered")
	private String phone1;

	@Column(name = "phone2")
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered")
	private String phone2;
	@Column(name = "website")
	private String website;

	public BookingDetails getBookingdetails() {
		return bookingdetails;
	}

	public void setBookingdetails(BookingDetails bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

	public Hotel(BookingDetails bookingdetails) {
		super();
		this.bookingdetails = bookingdetails;
	}

	@OneToOne(mappedBy = "hotels"/* , cascade = CascadeType.ALL */)
	private BookingDetails bookingdetails;
	
	
	  @OneToMany(mappedBy ="hotel",cascade=CascadeType.ALL)
		private List<RoomDetails>roomdetails;
	  
	 
	  public List<RoomDetails> getRoomdetails() {
		  return roomdetails; }
	  
	  public void setRoomdetails(List<RoomDetails> roomdetails) {
		  this.roomdetails = roomdetails; }
	  
	  public Hotel(List<RoomDetails> roomdetails) {
		  super(); 
		  this.roomdetails =  roomdetails; }
	 

	public Hotel() {
	};

	public Hotel(int hotel_id, String city, String hotel_name, String address, String description,
			double avg_rate_per_day, String email, String phone1, String phone2, String website) {
		super();
		this.hotel_id = hotel_id;
		this.city = city;
		this.hotel_name = hotel_name;
		this.address = address;
		this.description = description;
		this.avg_rate_per_day = avg_rate_per_day;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvg_rate_per_day() {
		return avg_rate_per_day;
	}

	public void setAvg_rate_per_day(double avg_rate_per_day) {
		this.avg_rate_per_day = avg_rate_per_day;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", city=" + city + ", hotel_name=" + hotel_name + ", address=" + address
				+ ", description=" + description + ", avg_rate_per_day=" + avg_rate_per_day + ", email=" + email
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", website=" + website + "]";
	}
}
