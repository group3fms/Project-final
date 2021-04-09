package com.cg.flightmgmt.exception;

public class BookingNotFoundException extends RuntimeException {
	public BookingNotFoundException(String str) {
		super(str);
	}
}
