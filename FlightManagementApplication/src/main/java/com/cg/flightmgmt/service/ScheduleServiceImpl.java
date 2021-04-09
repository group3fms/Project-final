package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.repository.ScheduleDao;
@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	ScheduleDao scheduleDao;
//	add schedule	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		return scheduleDao.save(schedule);
	
	}
//	view schedules
	@Override
	public List<Schedule> viewSchedule() {
		
		return (List<Schedule>) scheduleDao.findAll();
	}
// view schedule by scheduleid	
public Schedule viewScheduleById(BigInteger scheduleId) {
		Optional<Schedule> scheduleById=scheduleDao.findById(scheduleId);
		return scheduleById.get();
	}

}
