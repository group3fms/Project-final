package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "scheduled_flight")
public class ScheduledFlight {
	@Id
	BigInteger scheduledFlightId;
	
	@OneToOne	//OnetoOne relation between scheduledFlight and flight
	Flight flight;
	@NotNull
	Integer availableSeats;
	
	@OneToOne	//OnetoOne relation between scheduledFlight and schedule
//	@NotNull
	Schedule schedule;
//	non parameterized constructor
	public ScheduledFlight() {
		super();
	}

//	parameterized constructor	

	public ScheduledFlight(BigInteger scheduledFlightId, Flight flight, @NotNull Integer availableSeats,
		Schedule schedule) {
	super();
	this.scheduledFlightId = scheduledFlightId;
	this.flight = flight;
	this.availableSeats = availableSeats;
	this.schedule = schedule;
}

//	Getters and setters for all attributes


	public BigInteger getScheduledFlightId() {
		return scheduledFlightId;
	}

	public void setScheduledFlightId(BigInteger scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
//	tostring
	@Override
	public String toString() {
		return "ScheduledFlight [scheduledFlightId=" + scheduledFlightId + ", flight=" + flight + ", availableSeats="
				+ availableSeats + ", schedule=" + schedule + "]";
	}

}
