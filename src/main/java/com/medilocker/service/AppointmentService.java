package com.medilocker.service;

import com.medilocker.entity.Appointment;
import com.medilocker.entity.Patient;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.AppointmentRepository;
import com.medilocker.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private PatientRepository patientRepository;

    public Appointment addAppointment(Appointment appointment,int patient_id){
    	Patient patient = patientRepository.findById(patient_id)
                .orElseThrow(()->new CustomException("Patient","patient_id",patient_id));
    	
    	appointment.setPatient(patient);
       
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(int appointment_id){
        Optional<Appointment> appointment = appointmentRepository.findById(appointment_id);
        if (appointment.isPresent()){
            return appointment.get();
        }else {
            throw new CustomException("Appointment","appointment_id",appointment_id);
        }
    }

    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }

    public Appointment deleteAppointment(int appointment_id){
        Appointment appointment = appointmentRepository.findById(appointment_id)
                .orElseThrow(()-> new CustomException("Appointment","appointment_id",appointment_id));
        appointmentRepository.delete(appointment);
        return appointment;
    }
}
