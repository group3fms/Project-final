package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.Schedule;

public interface ScheduleService {
	
	public Schedule addSchedule(Schedule schedule);

	public List<Schedule> viewSchedule();
	public Schedule viewScheduleById(BigInteger id);
}
