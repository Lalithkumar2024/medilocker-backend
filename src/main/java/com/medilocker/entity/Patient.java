package com.medilocker.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private Users users;

    private String patientName;

    private String height;

    private String weight;

    private String bloodGroup;

    private String bloodPressure;

    private String sugarLevel;
    
    private LocalDate bloodDonationDate;

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(String sugarLevel) {
        this.sugarLevel = sugarLevel;
    }
    
    public LocalDate getBloodDonationDate() {
		return bloodDonationDate;
	}

	public void setBloodDonationDate(LocalDate bloodDonationDate) {
		this.bloodDonationDate = bloodDonationDate;
	}

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id 
				+ ", users=" + users 
				+ ", patientName=" + patientName 
				+ ", height=" + height 
				+ ", weight=" + weight 
				+ ", bloodGroup=" + bloodGroup 
				+ ", bloodPressure=" + bloodPressure
				+ ", sugarLevel=" + sugarLevel 
				+ ", bloodDonationDate=" + bloodDonationDate 
				+ "]";
	}

    

	
}
