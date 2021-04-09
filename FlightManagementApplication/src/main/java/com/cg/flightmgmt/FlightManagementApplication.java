package com.cg.flightmgmt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.service.AirportService;
import com.cg.flightmgmt.service.AirportServiceImpl;

@SpringBootApplication
@ComponentScan("com.cg.flightmgmt.controller")
@ComponentScan("com.cg.flightmgmt.dto")
@ComponentScan("com.cg.flightmgmt.exception")
@ComponentScan("com.cg.flightmgmt.repository")
@ComponentScan("com.cg.flightmgmt.service")
public class FlightManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(FlightManagementApplication.class, args);
		AirportService airportService=ctxt.getBean(AirportServiceImpl.class);
		List<Airport> airports = new ArrayList<>();
		airports.add(new Airport("Rajiv Gandhi International Airport", "Telangana", "101"));
		airports.add(new Airport("Trivandrum International Airport", "Kerela", "102"));
		airports.add(new Airport("Goa International Airport", "Goa", "103"));
		airports.add(new Airport("Pune International Airport", "Pune", "104"));
		airports.add(new Airport("Kullu Manali Airport", "Himachal Pradesh", "105"));
		for (Airport airport : airports) {
			airportService.addAirport(airport);
		}
	}

}
