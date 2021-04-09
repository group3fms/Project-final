package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.RecordAlreadyPresentException;
import com.cg.flightmgmt.service.FlightService;
import com.cg.flightmgmt.exception.*;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	FlightService flightService;
	//adding new flights
	@PostMapping
	public Flight addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
		return flight;
	}
	//view single flight with with given flightnumber
	@GetMapping("/{id}")
	public Flight viewFlight(@PathVariable("id") BigInteger id)
	{
		return flightService.viewFlight(id);
	}
	//get list of all flights
	@GetMapping
	public List<Flight> viewAllFlights()
	{
		return flightService.viewFlight();
	}
	//perform modifications to flight details
	@PutMapping
	public void modifyFlight(@RequestBody Flight flight)
	{
		flightService.modifyFlight(flight);
	}
	//remove flight detail 
	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable("id") BigInteger flightNo)
	{
		flightService.deleteFlight(flightNo);
	}
}
