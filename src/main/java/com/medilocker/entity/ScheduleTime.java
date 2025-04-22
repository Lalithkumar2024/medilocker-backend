package com.medilocker.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Schedule")
public class ScheduleTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schedule_id;

	@ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctor;
	
	private String doctorName;
	
	@Column(nullable = false)
	private LocalDate scheduleDate;
	
	private String fromTime;
	
	private String toTime;

	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public LocalDate getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	@Override
	public String toString() {
		return "ScheduleTime [Schedule_id=" + schedule_id 
				+ ", doctor=" + doctor 
				+ ", doctorName=" + doctorName
				+ ", scheduleDate=" + scheduleDate 
				+ ", fromTime=" + fromTime 
				+ ", toTime=" + toTime 
				+ "]";
	}
	
	
}
