package com.medilocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilocker.entity.ScheduleTime;
import com.medilocker.service.ScheduleTimeService;

@RestController
@RequestMapping("/schedule")
public class ScheduleTimeController {
	
    @Autowired
	private ScheduleTimeService scheduleTimeService;
	
    @PostMapping("/add/{doctor_id}")
	public ScheduleTime addScheduleTime(@PathVariable int doctor_id,@RequestBody ScheduleTime scheduleTime) {
		return scheduleTimeService.addScheduleTime(doctor_id, scheduleTime);
	}
	
    @GetMapping("/get/{schedule_id}")
    public ScheduleTime getScheduleTime(@PathVariable int schedule_id) {
    	return scheduleTimeService.getScheduleTime(schedule_id);
    }
    
    @GetMapping("/getAll")
    public List<ScheduleTime> getAllScheduleTime(){
    	return scheduleTimeService.getAllScheduleTime();
    }

}
