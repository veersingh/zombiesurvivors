package com.example.zomservivors.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zomservivors.entity.Location;
import com.example.zomservivors.entity.Survivors;
import com.example.zomservivors.service.SurvivorService;

@RestController
@RequestMapping("/survivors")
public class SurvivorController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SurvivorService survivorService;
	
	@GetMapping
	public List<Survivors> getAllSurvivers(){
		LOGGER.info("SurvivorController getAllSurvivers method");
		List<Survivors> survivors=survivorService.getAllSurvivors();
		return survivors;
		
	}
	
	@GetMapping("/infected")
	public List<Survivors> getAllInfectedSurvivers(){
		LOGGER.info("SurvivorController getAllInfectedSurvivers method");
		List<Survivors> survivors=survivorService.getAllInfectedSurvivors();
		return survivors;
		
	}
	
	@GetMapping("/noninfected")
	public List<Survivors> getAllNonInfectedSurvivers(){
		LOGGER.info("SurvivorController getAllNonInfectedSurvivers method");
		List<Survivors> survivors=survivorService.getAllNonInfectedSurvivors();
		return survivors;
		
	}
	
	@PostMapping
	public Survivors addSurvivors(@RequestBody Survivors survivor){
		LOGGER.info("SurvivorController addSurvivors method");
		Survivors survivorEntity=survivorService.addSurvivors(survivor);
		return survivorEntity;
		
	}
	
	@PutMapping("/{id}")
	public String UpdateSurvivorLocation(@RequestBody Location location,@PathVariable String id){
		LOGGER.info("SurvivorController UpdateSurvivorLocation method");
		 String response = survivorService.updateSurvivors(id, location);
		return response;
		
	}
	
	@PutMapping("/infected/{id}")
	public String UpdateSurvivorAsInfected(@PathVariable String id){
		LOGGER.info("SurvivorController UpdateSurvivorLocation method");
		 String response = survivorService.updateSurvivorAsInfected(id);
		return response;
		
	}
	
	@GetMapping("/reports/infected_in_percent")
	public String getPercentInfectedSurvivors(){
		LOGGER.info("SurvivorController getAllSurvivers method");
		String response =survivorService.getPercentInfectedSurvivors();
		return response;
		
	}
	
	@GetMapping("/reports/noninfected_in_percent")
	public String getPercentNonInfectedSurvivors(){
		LOGGER.info("SurvivorController getAllSurvivers method");
		String response =survivorService.getPercentNonInfectedSurvivors();
		return response;
		
	}
}
