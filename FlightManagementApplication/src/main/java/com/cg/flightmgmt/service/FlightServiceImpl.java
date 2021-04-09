package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.*;
import com.cg.flightmgmt.repository.FlightDao;
@Service	
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;
//	add flight
	@Override
	public Flight addFlight(Flight flight) throws RecordAlreadyPresentException {
		// TODO Auto-generated method stub
		return flightDao.save(flight);	
	}
//	modify flight
	@Override
	public Flight modifyFlight(Flight flight) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		Optional<Flight> flightById = flightDao.findById(flight.getFlightNumber());
		if (flightById.isPresent()) {
			return flightDao.save(flight);
			//performs modification/updation
		} else {
			throw new FlightNotFoundException("Flight number " + flight.getFlightNumber() + " does not exist!");
			//exception if flight with the given number does not exist
		}
	}
// view flight by flightno
	@Override
	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		Optional<Flight> flightById = flightDao.findById(flightno);
		if (flightById.isPresent()) {
			return flightById.get();
			//returns the flight details based on the flightnumber
		} else {
			throw new FlightNotFoundException("Flight number " + flightno + " does not exist!");
			//exception if flight with the given number does not exist

		}
	}
// view flights
	@Override
	public List<Flight> viewFlight() throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return (List<Flight>) flightDao.findAll();
	
		//list of files
	}
//	delete flights
	@Override
	public void deleteFlight(BigInteger flightno) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		Optional<Flight> fligthById = flightDao.findById(flightno);
		if (fligthById.isPresent()) {
			flightDao.deleteById(flightno);
			//removing flight detail from the flight table
		} else {
			throw new FlightNotFoundException("Flight number " + flightno + " does not exist!");
			//exception if flight with the given number does not exist

		}
	}
	

}
