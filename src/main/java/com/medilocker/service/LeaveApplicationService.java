package com.medilocker.service;

import com.medilocker.entity.Doctor;
import com.medilocker.entity.LeaveApplication;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.DoctorRepository;
import com.medilocker.repository.LeaveApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveApplicationService {

	@Autowired
    private LeaveApplicationRepository leaveApplicationRepository;
	
	@Autowired
    private DoctorRepository doctorRepository;

    public LeaveApplication addLeave(LeaveApplication leave,int doctor_id){
    	Doctor doctor = doctorRepository.findById(doctor_id)
    			.orElseThrow(()-> new CustomException("Doctor", "doctor_id", doctor_id));
    	
    	leave.setDoctor(doctor);
    	
        return leaveApplicationRepository.save(leave);
    }

    public LeaveApplication getLeave(int leave_id){
        Optional<LeaveApplication> leave = leaveApplicationRepository.findById(leave_id);
        if (leave.isPresent()){
            return leave.get();
        }else {
            throw new CustomException("LeaveApplication","leave_id",leave_id);
        }
    }

    public List<LeaveApplication> getAllLeave(){
        return leaveApplicationRepository.findAll();
    }
    
    public LeaveApplication updateLeave(int leave_id,LeaveApplication leaveApplication) {
    	LeaveApplication leave = leaveApplicationRepository.findById(leave_id)
    			.orElseThrow(()->new CustomException("LeaveApplication","leave_id",leave_id));
    	leave.setLeaveDate(leaveApplication.getLeaveDate());
    	leave.setLeaveReason(leaveApplication.getLeaveReason());
    	leave.setLeaveStatus(leaveApplication.getLeaveStatus());
    	
    	return leaveApplicationRepository.save(leave);
    }
}
