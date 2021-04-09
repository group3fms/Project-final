package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	BigInteger scheduleId;
	@OneToOne(fetch = FetchType.EAGER)
	Airport sourceAirport;
	@OneToOne(fetch = FetchType.EAGER)
	Airport destinationAirport;
	@Column(name = "arrival_date")
	LocalDate arrivalTime;
	@Column(name = "departure_date")
	LocalDate departureTime;
	
//	Non parameterized constructor
	public Schedule() {
		super();
	}

	

//	Parameterized constructor

	public Schedule(BigInteger scheduleId, Airport sourceAirport, Airport destinationAirport, LocalDate arrivalTime,
		LocalDate departureTime) {
	super();
	this.scheduleId = scheduleId;
	this.sourceAirport = sourceAirport;
	this.destinationAirport = destinationAirport;
	this.arrivalTime = arrivalTime;
	this.departureTime = departureTime;
}



//	Getters and setters for all attributes

	public BigInteger getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalDate getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDate getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}

}
