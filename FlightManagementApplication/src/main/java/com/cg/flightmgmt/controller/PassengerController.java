package com.cg.flightmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.repository.PassengerDao;
import com.cg.flightmgmt.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	PassengerService passengerService;
//	view list passengers
	@GetMapping
	public List<Passenger> viewPassenger() {
		return passengerService.viewPassenger();
	}
//	to add passengers 
	@PostMapping
	public Passenger addPassenger(@RequestBody Passenger passenger)
	{
		System.out.println(passenger);
		return passengerService.addPassenger(passenger);
	}

}
