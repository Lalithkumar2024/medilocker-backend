package com.medilocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilocker.entity.GraphData;
import com.medilocker.service.GraphDataService;

@RestController
@RequestMapping("/graph")
public class GraphDataController {

	@Autowired
	private GraphDataService graphDataService;
	
	@PostMapping("/add/{patient_id}")
	public GraphData addGraphData(@PathVariable int patient_id,@RequestBody GraphData graphData){
		return graphDataService.addGraphData(patient_id,graphData);
	}
	
	@GetMapping("/get/{graph_id}")
	public GraphData getGraphData(@PathVariable int graph_id) {
		return graphDataService.getGraphData(graph_id);
	}
	
	@GetMapping("/getAll")
	public List<GraphData> getAllGraphData(){
		return graphDataService.getAllGraphData();
	}
	
	
	
}
