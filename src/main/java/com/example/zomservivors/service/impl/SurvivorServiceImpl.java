package com.example.zomservivors.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zomservivors.entity.Location;
import com.example.zomservivors.entity.Survivors;
import com.example.zomservivors.repository.SurvivorRepository;
import com.example.zomservivors.service.SurvivorService;

@Service
public class SurvivorServiceImpl implements SurvivorService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired 
	private SurvivorRepository repository;
	
	public List<Survivors> getAllSurvivors() {
		 
		List<Survivors> survivors=repository.findAll();
		LOGGER.info("Total Survivors :"+ survivors.size());
		return survivors;
	}

	public Survivors addSurvivors(Survivors surviovor) {
		
		Survivors surviovors = repository.save(surviovor);
		LOGGER.info("Survivor added successfully with ID:"+ surviovors.getId());
		return surviovor;
	}

	public String updateSurvivors(String survivorId,Location location) {
		
		Optional<Survivors> surviovors = repository.findById(survivorId);
		 if(surviovors.isPresent()) {
			 Survivors entity = surviovors.get();
			 Location loc = entity.getLocation();
			 loc.setLatitude(location.getLatitude());
			 loc.setLongitude(location.getLongitude());
			 entity.setLocation(loc);
			 repository.save(entity);
			 LOGGER.info("Survivor Updated successfully with ID:"+ entity.getId());
			 return "Updated location successfully";
		 }
		 LOGGER.info("Survivor could not Update");
		return "Survivor ID is not present.";
	}

	@Override
	public String updateSurvivorAsInfected(String survivorId) {
		Optional<Survivors> surviovors = repository.findById(survivorId);
		 if(surviovors.isPresent()) {
			 Survivors entity = surviovors.get();
			 entity.setInfected(true);
			 repository.save(entity);
			 LOGGER.info("Survivor Updated as Infected:"+ entity.getId());
			 return "Survivor Updated as Infected successfully";
		 }
		 LOGGER.info("Survivor did not update as Infected.");
		return "Survivor ID is not present.";
	}
	
	public String getPercentInfectedSurvivors() {
		
		List<Survivors> survivors = repository.findAll();
		AtomicInteger infectedSurvivors=new AtomicInteger();
		survivors.stream().filter(surviv->surviv.isInfected()).forEach(surviv->{
			
			infectedSurvivors.getAndIncrement();
		});
		
		LOGGER.info("Total Survivor size:"+ survivors.size());
		LOGGER.info("Infected Survivor size:"+ infectedSurvivors.get());
		
		return "Percentage of infected survivors :" + ((double)infectedSurvivors.get()/survivors.size())*100 + "%";
	}

	public String getPercentNonInfectedSurvivors() {
		List<Survivors> survivors = repository.findAll();
		AtomicInteger nonInfectedSurvivors=new AtomicInteger();
		survivors.stream().filter(surviv->!surviv.isInfected()).forEach(surviv->{
			nonInfectedSurvivors.getAndIncrement();
		});
		
		LOGGER.info("Total Survivor size:"+ survivors.size());
		LOGGER.info("Non Infected Survivor size:"+ nonInfectedSurvivors.get());
		
		return "Percentage of non infected survivors :" + ((double)nonInfectedSurvivors.get()/survivors.size())*100 + "%";
	}

	public List<Survivors> getAllInfectedSurvivors() {
		List<Survivors> survivors = repository.findAll();
		List<Survivors> infectedSurvivors= survivors.stream().filter(surviv->surviv.isInfected()).collect(Collectors.toList());
		LOGGER.info("Total  Infected Survivor size:"+ infectedSurvivors.size());
		return infectedSurvivors;
		
	}

	public List<Survivors> getAllNonInfectedSurvivors() {
		List<Survivors> survivors = repository.findAll();
		List<Survivors> noninfectedSurvivors= survivors.stream().filter(surviv->!surviv.isInfected()).collect(Collectors.toList());
		LOGGER.info("Total  Non Infected Survivor size:"+ noninfectedSurvivors.size());
		return noninfectedSurvivors;
	}

	


}
