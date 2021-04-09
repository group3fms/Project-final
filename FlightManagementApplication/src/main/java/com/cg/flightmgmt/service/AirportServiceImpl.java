package com.cg.flightmgmt.service;

import com.cg.flightmgmt.service.AirportService;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.flightmgmt.repository.AirportDao;
import com.cg.flightmgmt.exception.RecordAlreadyPresentException;
import com.cg.flightmgmt.exception.RecordNotFoundException;

@Service
public class AirportServiceImpl  implements AirportService{
	@Autowired
	AirportDao airportDao;
	
	
	//view all airports
	@Override
	public List<Airport> viewAllAirport(){
		
		return (List<Airport>) airportDao.findAll();
	}
	
	public Airport addAirport(Airport airport)
	{
		return airportDao.save(airport);
	}
	//view airport by code
	@Override
	public Airport viewAirport(String airportCode) {
		Optional<Airport> findByCode = airportDao.findById(airportCode);
		if(findByCode.isPresent()) {
			return findByCode.get();
		}
		else 
			throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");	
		}
}
	
	
	
	
	
