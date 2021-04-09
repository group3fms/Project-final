package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.repository.BookingDao;
import com.cg.flightmgmt.exception.RecordAlreadyPresentException;
import com.cg.flightmgmt.exception.RecordNotFoundException;
import com.cg.flightmgmt.exception.UserNotValidException;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Passenger;

@Service
public class BookingServiceImpl implements BookingService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	BookingDao bookingDao;
	@Autowired
	PassengerService passengerService;
	/*
	 * making new Booking
	 */
	@Override
	public Booking addBooking(Booking newBooking) throws RecordAlreadyPresentException {
		Booking booking=newBooking;
		bookingDao.save(newBooking);
		newBooking.setPassengerList(passengerService.viewPassenger(newBooking.getBookingId()));
//		System.out.println(newBooking);
		return bookingDao.save(newBooking);
	}

	/*
	 * update booking made
	 */
	@Override
	public Booking modifyBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			 Booking booking=bookingDao.save(findBookingById.get());
			 booking.setPassengerList(passengerService.viewPassenger(booking.getBookingId()));
			 return bookingDao.save(booking);
		} else
			throw new RecordNotFoundException(
					"Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		
	}

	/*
	 * deleting the booking
	 */

	@Override
	public void deleteBooking(BigInteger bookingId) {

		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingDao.deleteById(bookingId);

		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}

	/*
	 * view all booking
	 */
	@Override
	public List<Booking> viewBooking() {

		return (List<Booking>) bookingDao.findAll();
	}

	/*
	 * view booking by Id
	 */
	@Override
	public Booking viewBooking(BigInteger bookingId) throws RecordNotFoundException {
		Optional<Booking> findById = bookingDao.findById(bookingId);
		if (findById.isPresent()) {
			Booking findBooking = findById.get();
			return findBooking;
		} else
			throw new RecordNotFoundException("No record found with ID " + bookingId);
	}
	/*
	 * validating passenger UIN
	 */
	public void validatePassenger(Passenger passenger) throws UserNotValidException
	{
		BigInteger passengerUIN=passenger.getPassengerUIN();
		int len=passengerUIN.toString().length();
		if(len!=12)
		{
			throw new UserNotValidException("Entered UIN is not valid");
		}
	}
}
