package com.medilocker.controller;

import com.medilocker.entity.Doctor;
import com.medilocker.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor/{doctor_id}")
    public Doctor addDoctor(@RequestBody Doctor doctor,@PathVariable int doctor_id){
        return doctorService.addDoctor(doctor_id,doctor);
    }

    @GetMapping("/getDoctor/{doctor_id}")
    public Doctor getDoctor(@PathVariable int doctor_id){
        return doctorService.getDoctor(doctor_id);
    }

    @GetMapping("/getAllDoctor")
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }

    @PutMapping("/updateDoctor/{doctor_id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor , @PathVariable int doctor_id){
        return doctorService.updateDoctor(doctor_id,doctor);
    }

    @DeleteMapping("deleteDoctor/{doctor_id}")
    public Doctor deleteDoctor(@PathVariable int doctor_id){
        return doctorService.deleteDoctor(doctor_id);
    }
    
    @GetMapping("/getDoctorId/{user_id}")
    public Integer getDoctorId(@PathVariable int user_id) {
    	return doctorService.getUserID(user_id);
    	
    }
}
