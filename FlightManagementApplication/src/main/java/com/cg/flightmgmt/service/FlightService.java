package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.RecordAlreadyPresentException;


public interface FlightService {
public Flight addFlight(Flight flight) throws RecordAlreadyPresentException;
public Flight modifyFlight(Flight flight);
public Flight viewFlight(BigInteger flightno);
public List<Flight> viewFlight();
public void deleteFlight(BigInteger flightno);
}
