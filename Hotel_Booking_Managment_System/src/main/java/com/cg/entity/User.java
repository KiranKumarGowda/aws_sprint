package com.cg.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	@NotBlank(message = "Name is mandatory")
	@Column(name = "user_name")
	private String user_name;
	@NotBlank(message = "Email is mandatory")
	@Column(name = "user_email")
	private String user_email;
	@NonNull
	@NotBlank(message = "New password is mandatory")
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "mobile")
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered")
	private String mobile;
	@Column(name = "address")
	private String address;

	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	public BookingDetails bookingdetails;

	public User(BookingDetails bookingdetails) {
		super();
		this.bookingdetails = bookingdetails;
	}

	public BookingDetails getBookingdetails() {
		return bookingdetails;
	}

	public void setBookingdetails(BookingDetails bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

	public User() {
	}

	public User(int user_id, String user_name, String user_email, String password, String role, String mobile,
			String address) {

		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", password="
				+ password + ", role=" + role + ", mobile=" + mobile + ", address=" + address + "]";
	}

}