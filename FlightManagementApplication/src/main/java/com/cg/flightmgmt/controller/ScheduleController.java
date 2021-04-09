package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
@Autowired
ScheduleService scheduleService;
// add schedules
@PostMapping
public Schedule addSchedule(Schedule schedule)
{
	return scheduleService.addSchedule(schedule);
}
// view schedules
@GetMapping
public List<Schedule> viewSchedule()
{
	return scheduleService.viewSchedule();
}
// view schedule by id
@GetMapping("/id")
public Schedule viewSchedule(@PathVariable("id") BigInteger scheduleId) 
{
	return scheduleService.viewScheduleById(scheduleId);
}
}
