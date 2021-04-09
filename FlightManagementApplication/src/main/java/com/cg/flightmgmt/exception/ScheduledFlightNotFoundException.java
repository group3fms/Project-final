package com.cg.flightmgmt.exception;

public class ScheduledFlightNotFoundException extends Exception {
String message;

public ScheduledFlightNotFoundException(String message) {
	super(message);
}

}
