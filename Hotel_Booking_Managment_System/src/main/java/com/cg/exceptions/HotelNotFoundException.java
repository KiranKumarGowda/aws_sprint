package com.cg.exceptions;

public class HotelNotFoundException extends RuntimeException{
	public HotelNotFoundException(String string) {
		super(string);
	}
}
