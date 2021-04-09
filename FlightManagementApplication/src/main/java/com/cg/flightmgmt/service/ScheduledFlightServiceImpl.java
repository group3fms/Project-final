package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.ScheduledFlightNotFoundException;
import com.cg.flightmgmt.repository.ScheduleDao;
import com.cg.flightmgmt.repository.ScheduledFlightDao;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightServices {
	@Autowired
	ScheduleDao scheduledao;

	@Autowired
	ScheduledFlightDao scheduledflightdao;

//	add scheduledflight
	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		return scheduledflightdao.save(scheduledFlight);
	}
//	view scheduled flight by flightNo
	@Override
	public ScheduledFlight viewScheduledFlights(BigInteger flightNumber) throws ScheduledFlightNotFoundException {
		boolean flag = false;
		List<ScheduledFlight> list = (List<ScheduledFlight>) scheduledflightdao.findAll();
		ScheduledFlight scheduledFlight = null;
		for (ScheduledFlight scheduledFlight2 : list) {
			if (scheduledFlight2.getFlight().getFlightNumber() == flightNumber) {
				scheduledFlight = scheduledFlight2;
				flag = true;
			}
		}
		if (flag) {
			return scheduledFlight;
		} else {
			throw new ScheduledFlightNotFoundException("Flight Number: " + flightNumber + " is not found.");
		}
	}
//	view scheduledflight by airports
	@Override
	public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport, Airport destinationAirport) {
		List<ScheduledFlight> scheduledFlightList = (List<ScheduledFlight>) scheduledflightdao.findAll();
		List<ScheduledFlight> updatescheduledFlightList = null;
		for (ScheduledFlight scheduledFlight : scheduledFlightList) {
			if (sourceAirport.equals(scheduledFlight.getSchedule().getSourceAirport())
					&& destinationAirport.equals(scheduledFlight.getSchedule().getDestinationAirport())) {
				updatescheduledFlightList.add(scheduledFlight);
			}

		}
		return updatescheduledFlightList;
	}
//	view all scheduledflights
	@Override
	public List<ScheduledFlight> viewScheduledFlights() {
		return (List<ScheduledFlight>) scheduledflightdao.findAll();
	}
//	modifying scheduledflight
	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		ScheduledFlight updateScheduledFlight = scheduledflightdao.findById(scheduledFlight.getScheduledFlightId())
				.get();
		Schedule updateSchedule = scheduledao.findById(scheduledFlight.getSchedule().getScheduleId()).get();
		updateScheduledFlight.setAvailableSeats(scheduledFlight.getAvailableSeats());
		updateSchedule.setDestinationAirport(scheduledFlight.getSchedule().getDestinationAirport());
		updateSchedule.setSourceAirport(scheduledFlight.getSchedule().getSourceAirport());
		updateSchedule.setArrivalTime(scheduledFlight.getSchedule().getArrivalTime());
		updateSchedule.setDepartureTime(scheduledFlight.getSchedule().getDepartureTime());
//		updateScheduledFlight.setSchedule(updateSchedule);
//		updateScheduledFlight.setFlight(flight);
		scheduledflightdao.save(updateScheduledFlight);
		return updateScheduledFlight;

	}
//	delete scheduledflight
	@Override
	public void deleteScheduledFlight(BigInteger scheduledFlightId) throws ScheduledFlightNotFoundException {
		Optional<ScheduledFlight> scheduledFlight = scheduledflightdao.findById(scheduledFlightId);
		if (!scheduledFlight.isPresent()) {
			scheduledflightdao.deleteById(scheduledFlightId);
		}

		else {
			throw new ScheduledFlightNotFoundException("Schdeuled Flight: " + scheduledFlightId + " is not founded.");
		}
	}

}
