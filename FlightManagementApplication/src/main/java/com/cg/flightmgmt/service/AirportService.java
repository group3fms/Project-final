package com.cg.flightmgmt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.dto.Airport;

public interface AirportService {
	public List<Airport> viewAllAirport();
	public Airport addAirport(Airport airport);
	public Airport viewAirport(String airportCode);

	
}