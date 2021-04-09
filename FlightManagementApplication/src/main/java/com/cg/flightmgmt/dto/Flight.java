package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "flight")
public class Flight {
	@Id
	BigInteger flightNumber;
	@NotNull
	String flightModel;
	@NotNull
	String carrierName;
	@NotNull
	int seatCapacity;
	
//	Nonparameterized constructor
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
// 	parameterized constructor

	public Flight( BigInteger flightNumber, @NotNull String flightModel, @NotNull String carrierName,
		@NotNull int seatCapacity) {
	super();
	this.flightNumber = flightNumber;
	this.flightModel = flightModel;
	this.carrierName = carrierName;
	this.seatCapacity = seatCapacity;
}


//	Getters and setters for all attributes

	public BigInteger getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
//	tostring
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCapacity=" + seatCapacity + "]";
	}
	
	
}
