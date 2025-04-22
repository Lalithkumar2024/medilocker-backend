package com.medilocker.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Graph")
public class GraphData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int graph_id;
	
	@ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "patient_id")
    private Patient patient;

	private String patientName;
	
	@Column(nullable = false)
	private LocalDate dataDate;
	
	private Integer beforeEating;
	
	private Integer afterEating;

	public int getGraph_id() {
		return graph_id;
	}

	public void setGraph_id(int graph_id) {
		this.graph_id = graph_id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public LocalDate getDataDate() {
		return dataDate;
	}

	public void setDataDate(LocalDate dataDate) {
		this.dataDate = dataDate;
	}

	public Integer getBeforeEating() {
		return beforeEating;
	}

	public void setBeforeEating(Integer beforeEating) {
		this.beforeEating = beforeEating;
	}

	public Integer getAfterEating() {
		return afterEating;
	}

	public void setAfterEating(Integer afterEating) {
		this.afterEating = afterEating;
	}

	@Override
	public String toString() {
		return "GraphData [graph_id=" + graph_id 
				+ ", patient=" + patient 
				+ ", patientName=" + patientName
				+ ", dataDate=" + dataDate 
				+ ", beforeEating=" + beforeEating 
				+ ", afterEating=" + afterEating 
				+ "]";
	}

}
