package com.medilocker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_id;

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "patient_id")
    private Patient patient;

    private String doctorName;

    @Column(nullable = false,unique = true)
    private LocalDate appointmentDate;

    @Column(nullable = false,unique = true)
    private String appointmentTime;

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_id=" + appointment_id +
                ", patient=" + patient +
                ", doctorName='" + doctorName + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                '}';
    }
}
