package com.example.zomservivors.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zomservivors.entity.RobotEntity;
import com.example.zomservivors.service.RobotService;

@RestController
@RequestMapping("/robots")
public class RobotController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	RobotService robotService;
	
	@GetMapping
	public List<RobotEntity> getAllRobots(){
	
		LOGGER.info("RobotController getAllRobots method");
		List<RobotEntity> robots=robotService.getRobots();
		return robots;
		
	}
	
	@GetMapping("/{category}")
	public List<RobotEntity> getAllRobotsByCategory(@PathVariable String category){
	
		LOGGER.info("RobotController getAllRobotsByCategory method with category:" +category);
		List<RobotEntity> robots=robotService.getRobotsByCategory(category);
		return robots;
		
	}
}
