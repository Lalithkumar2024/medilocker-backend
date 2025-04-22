package com.medilocker.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilocker.entity.GraphData;
import com.medilocker.entity.Patient;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.GraphDataRepository;
import com.medilocker.repository.PatientRepository;

@Service
public class GraphDataService {
	
	@Autowired
	private GraphDataRepository graphDataRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	public GraphData addGraphData(int patient_id,GraphData graphData) {
		
		Patient patient = patientRepository.findById(patient_id)
				.orElseThrow(() -> new CustomException("Patient", "patient_id", patient_id));
		
		graphData.setPatient(patient);
		graphData.setPatientName(patient.getPatientName());
		graphData.setDataDate(LocalDate.now());
		
		return graphDataRepository.save(graphData);	
	}
	
	public GraphData getGraphData(int graph_id) {
		
		Optional<GraphData> graphData = graphDataRepository.findById(graph_id);
		if(graphData.isPresent()) {
			return graphData.get();
		}else {
			throw new CustomException("GraphData", "graph_id", graph_id);
		}
	}

	public List<GraphData> getAllGraphData(){
		return graphDataRepository.findAll();
	}
}
