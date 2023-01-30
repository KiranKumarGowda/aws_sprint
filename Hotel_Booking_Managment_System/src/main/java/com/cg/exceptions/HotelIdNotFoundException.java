package com.cg.exceptions;

public class HotelIdNotFoundException extends RuntimeException{
	public HotelIdNotFoundException(String string) {
		super(string);
	}
}
