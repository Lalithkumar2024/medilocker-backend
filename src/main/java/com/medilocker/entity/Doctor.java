package com.medilocker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctor_id;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private Users users;

    private String doctorName;

    private String specialization;

    private String yoe;

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getYoe() {
        return yoe;
    }

    public void setYoe(String yoe) {
        this.yoe = yoe;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + doctor_id +
                ", users=" + users +
                ", specialization='" + specialization + '\'' +
                ", yoe='" + yoe + '\'' +
                '}';
    }
}
