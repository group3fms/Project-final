package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.flightmgmt.repository.AirportDao;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.service.AirportService;
import com.cg.flightmgmt.service.AirportServiceImpl;

@RestController
@RequestMapping("/airport")
public class AirportController {
	List<Airport> airports;

//	@Autowired
//	AirportDao airportDao;
	public AirportController() {
//		System.out.println("Airport dao " +airportDao);
		
	}

	@Autowired(required = true)
	AirportService airportService;

	// To view airport by code

	@GetMapping("{code}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airport viewAirport(@PathVariable("code") String airportCode) {
		return airportService.viewAirport(airportCode);
	}
// view all aiports
	@GetMapping
	public List<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
	}

}
