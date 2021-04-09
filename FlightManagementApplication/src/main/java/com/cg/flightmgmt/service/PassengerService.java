package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.Passenger;

public interface PassengerService {
public Passenger addPassenger(Passenger passenger);

public List<Passenger> viewPassenger();
public List<Passenger> viewPassenger(BigInteger bookingId);
}
