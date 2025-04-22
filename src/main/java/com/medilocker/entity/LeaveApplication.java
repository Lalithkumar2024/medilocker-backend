package com.medilocker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Leave Application")
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leave_id;

    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctor;
    
    @Column(nullable = false)
    private LocalDate leaveDate;
    
    @Column(nullable = false)
    private String leaveReason;
    
    private String leaveStatus;

    public int getLeave_id() {
        return leave_id;
    }

    public void setLeave_id(int leave_id) {
        this.leave_id = leave_id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }
    
    public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

    @Override
    public String toString() {
        return "LeaveApplication{" +
                "leave_id=" + leave_id +
                ", doctor=" + doctor +
                ", leaveDate=" + leaveDate +
                ", leaveReason='" + leaveReason + '\'' +
                ", leaveStatus='" + leaveStatus + '\'' +
                '}';
    }

}
