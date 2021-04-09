	package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import net.bytebuddy.asm.Advice.Local;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	BigInteger bookingId;
	LocalDate bookingDate;
	int noOfPassengers;
	@ManyToOne			//many to one relation between booking and user
	User userId;
	@OneToMany			//One to many relation between booking and passenger
	List<Passenger> passengerList;
	double ticketCost;
	@OneToOne(fetch = FetchType.EAGER)	//One to one relation between booking and flight
	Flight flight;
	
//	Non parameterized constructor
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	Parameterized constructor

	public Booking(BigInteger bookingId, LocalDate bookingDate, int noOfPassengers, User userId,
			List<Passenger> passengerList, double ticketCost, Flight flight) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.noOfPassengers = noOfPassengers;
		this.userId = userId;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flight = flight;
	}


//	getters and setters for all attributes
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
//	Tostring
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", noOfPassengers=" + noOfPassengers
				+ ", userId=" + userId + ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", flight="
				+ flight + "]";
	}

	
}
