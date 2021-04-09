package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.repository.PassengerDao;
@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerDao passengerDao;
//	Add passenger
	@Override
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return passengerDao.save(passenger);
	}
//	View passengers
	@Override
	public List<Passenger> viewPassenger() {
		// TODO Auto-generated method stub
		return (List<Passenger>) passengerDao.findAll();
	}
//	view passenger by bookingid	
	@Override
	public List<Passenger> viewPassenger(BigInteger bookingId) {
		List<Passenger> list = passengerDao.getPassengerList(bookingId);
		return list;
	}
}
