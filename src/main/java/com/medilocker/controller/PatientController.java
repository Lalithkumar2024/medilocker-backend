package com.medilocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilocker.entity.Patient;
import com.medilocker.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping("/addPatient/{patient_id}")
    public Patient addPatient(@RequestBody Patient patient,@PathVariable int patient_id){
        return patientService.addPatient(patient_id,patient);
    }

    @GetMapping("/getPatient/{patient_id}")
    public Patient getPatient(@PathVariable int patient_id){
        return patientService.getPatient(patient_id);
    }

    @GetMapping("/getAllPatient")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @PutMapping("/updatePatient/{patient_id}")
    public Patient updatePatient(@RequestBody Patient patient , @PathVariable int patient_id){
        return patientService.updatePatient(patient_id,patient);
    }

    @DeleteMapping("deletePatient/{patient_id}")
    public Patient deletePatient(@PathVariable int patient_id){
        return patientService.deletePatient(patient_id);
    }
    
    @GetMapping("/getPatientId/{user_id}")
    public Integer getPatientId(@PathVariable int user_id) {
    	return patientService.getUserID(user_id);
    	
    }
}
