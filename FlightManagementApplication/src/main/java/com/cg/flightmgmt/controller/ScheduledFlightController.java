package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.ScheduledFlightNotFoundException;
import com.cg.flightmgmt.service.AirportService;
import com.cg.flightmgmt.service.FlightService;
import com.cg.flightmgmt.service.ScheduledFlightServices;

@RestController
@RequestMapping("/scheduledflight")
public class ScheduledFlightController {
	@Autowired
	ScheduledFlightServices scheduledFlightServices;
	
	@Autowired
	AirportService airportService;
	
	@Autowired
	FlightService flightService;
//	add scheduledflight
	@PostMapping
	public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		System.out.println(scheduledFlight);
		return scheduledFlightServices.addScheduledFlight(scheduledFlight);
	}
//	view scheduledflight by id
	@GetMapping("/{id}")
	public ScheduledFlight viewScheduledFlights(@PathVariable("id") BigInteger flightNumber) throws ScheduledFlightNotFoundException{
		return scheduledFlightServices.viewScheduledFlights(flightNumber);
	}
//	view scheduledflight by airports
	@GetMapping("/{source}/{destination}")
	public List<ScheduledFlight> viewScheduledFlights(@PathVariable(name = "source") String sourceAirport,@PathVariable(name = "destination") String destinationAirport){
		return scheduledFlightServices.viewScheduledFlights(airportService.viewAirport(sourceAirport), airportService.viewAirport(destinationAirport));
	}
//	view scheduled flights
	@GetMapping
	public List<ScheduledFlight> viewScheduledFlights(){
		return scheduledFlightServices.viewScheduledFlights();
	}
//	update scheduledflight
	@PutMapping
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		return scheduledFlightServices.modifyScheduledFlight(scheduledFlight);
	}
//	delete scheduledflight
	@DeleteMapping
	public void deleteScheduledFlight(@RequestBody BigInteger scheduledFlightId) throws ScheduledFlightNotFoundException{
		 scheduledFlightServices.deleteScheduledFlight(scheduledFlightId);
	}
}
