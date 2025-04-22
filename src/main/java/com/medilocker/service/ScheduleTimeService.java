package com.medilocker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilocker.entity.Doctor;
import com.medilocker.entity.ScheduleTime;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.DoctorRepository;
import com.medilocker.repository.ScheduleTimeRepository;

@Service
public class ScheduleTimeService {
	
	@Autowired
	private ScheduleTimeRepository scheduleTimeRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public ScheduleTime addScheduleTime(int doctor_id,ScheduleTime scheduleTime) {
		Doctor doctor = doctorRepository.findById(doctor_id)
				.orElseThrow(()-> new CustomException("Doctor", "doctor_id", doctor_id));
		
		scheduleTime.setDoctor(doctor);
		scheduleTime.setDoctorName(doctor.getDoctorName());
		
		return scheduleTimeRepository.save(scheduleTime);
	}
	
	public ScheduleTime getScheduleTime(int schedule_id) {
		
		Optional<ScheduleTime> scheduleTime = scheduleTimeRepository.findById(schedule_id);
		if(scheduleTime.isPresent()) {
			return scheduleTime.get();
		}else {
			throw new CustomException("ScheduleTime", "schedule_id", schedule_id);
		}
	}

	public List<ScheduleTime> getAllScheduleTime(){
		return scheduleTimeRepository.findAll();
	}

}
