package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.ScheduledFlightNotFoundException;

public interface ScheduledFlightServices {
public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);
public ScheduledFlight viewScheduledFlights(BigInteger flightNumber) throws ScheduledFlightNotFoundException;
public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport);
public List<ScheduledFlight> viewScheduledFlights();
public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);
public void deleteScheduledFlight(BigInteger scheduledFlightId) throws ScheduledFlightNotFoundException;

}
