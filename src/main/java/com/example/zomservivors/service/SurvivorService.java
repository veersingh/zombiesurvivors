package com.example.zomservivors.service;

import java.util.List;

import com.example.zomservivors.entity.Location;
import com.example.zomservivors.entity.Survivors;

public interface SurvivorService {

	public List<Survivors> getAllSurvivors();
	public Survivors addSurvivors(Survivors surviovors);
	public String updateSurvivors(String survivorId,Location location);
	public String updateSurvivorAsInfected(String survivorId);
	public String getPercentInfectedSurvivors();
	public String  getPercentNonInfectedSurvivors();
	public List<Survivors> getAllInfectedSurvivors();
	public List<Survivors> getAllNonInfectedSurvivors();
}
