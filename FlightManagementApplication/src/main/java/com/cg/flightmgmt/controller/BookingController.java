package com.cg.flightmgmt.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.exception.RecordAlreadyPresentException;
import com.cg.flightmgmt.exception.RecordNotFoundException;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.service.BookingService;
import com.cg.flightmgmt.service.ScheduledFlightServiceImpl;
import com.cg.flightmgmt.service.ScheduledFlightServices;
import com.cg.flightmgmt.service.UserService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	ScheduledFlightServices scheduledFlight;
	
	@Autowired
	UserService user;
	
	@Autowired(required= true)
	BookingService bookingService;
//	add bookings
	@PostMapping
	public Booking addBooking(@RequestBody Booking newBooking) {
		
		return bookingService.addBooking(newBooking);
		
	}
// returns all bookings
	@GetMapping
	public Iterable<Booking> readAllBookings() {

		return bookingService.viewBooking();
	}
// update/modify bookings
	@PutMapping
	public Booking modifyBooking(@RequestBody Booking updateBooking) {

		return bookingService.modifyBooking(updateBooking);
		
	}
//	view bookings by id
	@GetMapping("/{id}")
	public Booking viewBooking(@PathVariable("id") BigInteger bookingId) {

		return bookingService.viewBooking(bookingId);
	}
// remove bookings
	@DeleteMapping("/{id}")
	public void deleteBookingByID(@PathVariable("id") BigInteger bookingId) {

		bookingService.deleteBooking(bookingId);
	}
}
