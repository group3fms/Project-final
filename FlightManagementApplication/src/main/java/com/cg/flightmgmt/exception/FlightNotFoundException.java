package com.cg.flightmgmt.exception;

public class FlightNotFoundException extends RuntimeException {
	public FlightNotFoundException(String str) {
		super(str);
	}
}
