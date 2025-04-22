package com.medilocker.service;

import com.medilocker.entity.Doctor;
import com.medilocker.entity.Users;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.DoctorRepository;
import com.medilocker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Doctor addDoctor(int doctor_id,Doctor doctor){
    	 Doctor doctors = doctorRepository.findById(doctor_id)
                 .orElseThrow(()->new CustomException("Doctor","doctor_id",doctor_id));
         doctors.setSpecialization(doctor.getSpecialization());
         doctors.setYoe(doctor.getYoe());
         return doctorRepository.save(doctors);
    }

    public Doctor getDoctor(int doctor_id){
        Optional<Doctor> doctor = doctorRepository.findById(doctor_id);
        if(doctor.isPresent()){
            return doctor.get();
        }else {
            throw new CustomException("Doctor","doctor_id",doctor_id);
        }
    }

    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(int doctor_id,Doctor doctor){
        Doctor doctors = doctorRepository.findById(doctor_id)
                .orElseThrow(()->new CustomException("Doctor","doctor_id",doctor_id));
        doctors.setSpecialization(doctor.getSpecialization());
        doctors.setYoe(doctor.getYoe());
        return doctorRepository.save(doctors);
    }

    public Doctor deleteDoctor(int doctor_id){
        Doctor doctor = doctorRepository.findById(doctor_id)
                .orElseThrow(()->new CustomException("Doctor","doctor_id",doctor_id));
        doctorRepository.delete(doctor);
        return doctor;
    }
    
    public Integer getUserID (int user_id) {
    	Users user = userRepository.findById(user_id)
    			.orElseThrow(()-> new CustomException("Users", "user_id", user_id));
    	Integer doctorId = user.getDoctor().getDoctor_id();
    	return doctorId;
    }
}
