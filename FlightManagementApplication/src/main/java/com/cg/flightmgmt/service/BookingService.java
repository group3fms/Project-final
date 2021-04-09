package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Passenger;

public interface BookingService {

	public Booking addBooking(Booking newBooking);

	public Booking modifyBooking(Booking newBooking);

	public void deleteBooking(BigInteger bookingId);

	public List<Booking> viewBooking();

	public Booking viewBooking(BigInteger bookingId);
	
	public void validatePassenger(Passenger passenger);
}
