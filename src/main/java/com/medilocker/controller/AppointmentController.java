package com.medilocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilocker.entity.Appointment;
import com.medilocker.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/addAppointment/{patient_id}")
    public Appointment addAppointment(@RequestBody Appointment appointment,@PathVariable int patient_id){
        return appointmentService.addAppointment(appointment,patient_id);
    }

    @GetMapping("/getAppointment/{appointment_id}")
    public Appointment getAppointment(@PathVariable int appointment_id){
        return appointmentService.getAppointment(appointment_id);
    }

    @GetMapping("/getAllAppointment")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointment();
     }

    @DeleteMapping("deleteAppointment/{appointment_id}")
    public Appointment deleteAppointment(@PathVariable int appointment_id){
        return appointmentService.deleteAppointment(appointment_id);
    }
}
