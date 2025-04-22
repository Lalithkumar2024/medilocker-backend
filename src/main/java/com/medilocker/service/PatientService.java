package com.medilocker.service;

import com.medilocker.entity.Patient;
import com.medilocker.entity.Users;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.PatientRepository;
import com.medilocker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService{

    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Patient addPatient(int patient_id,Patient patient){
    	 Patient patients = patientRepository.findById(patient_id)
                 .orElseThrow(()->new CustomException("Patient","patient_id",patient_id));
         patients.setHeight(patient.getHeight());
         patients.setWeight(patient.getWeight());
         patients.setBloodGroup(patient.getBloodGroup());
         patients.setBloodPressure(patient.getBloodPressure());
         patients.setSugarLevel(patient.getSugarLevel());
         patients.setBloodDonationDate(patient.getBloodDonationDate());
         return patientRepository.save(patients);
    }

    public Patient getPatient(int patient_id){
        Optional<Patient> patient = patientRepository.findById(patient_id);
        if(patient.isPresent()){
            return patient.get();
        }else {
            throw new CustomException("Patient","patient_id",patient_id);
        }
    }

    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public Patient updatePatient(int patient_id,Patient patient){
        Patient patients = patientRepository.findById(patient_id)
                .orElseThrow(()->new CustomException("Patient","patient_id",patient_id));
        patients.setHeight(patient.getHeight());
        patients.setWeight(patient.getWeight());
        patients.setBloodGroup(patient.getBloodGroup());
        patients.setBloodPressure(patient.getBloodPressure());
        patients.setSugarLevel(patient.getSugarLevel());
        patients.setBloodDonationDate(patient.getBloodDonationDate());
        return patientRepository.save(patients);
    }

    public Patient deletePatient(int patient_id){
        Patient patient = patientRepository.findById(patient_id)
                .orElseThrow(()->new CustomException("Patient","patient_id",patient_id));
        patientRepository.delete(patient);
        return patient;
    }
    
    public Integer getUserID (int user_id) {
    	Users user = userRepository.findById(user_id)
    			.orElseThrow(()-> new CustomException("Users", "user_id", user_id));
    	Integer patientId = user.getPatient().getPatient_id();
    	return patientId;
    }
}
