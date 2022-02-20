package com.example.zomservivors.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.zomservivors.entity.RobotEntity;
import com.example.zomservivors.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	RestTemplate restTemplate;
	@Value("${robotcpu.url}")
	String  robotSystemUrl;
	
	@Override
	public List<RobotEntity> getRobots() {
		
		ResponseEntity<RobotEntity[]> responseEntity =
				   restTemplate.getForEntity(robotSystemUrl, RobotEntity[].class);
		
		RobotEntity [] objects= responseEntity.getBody();
		LOGGER.info("Robot list :"+ objects.length);
		return	Arrays.stream(objects).collect(Collectors.toList());
		 
	}

	@Override
	public List<RobotEntity> getRobotsByCategory(String category) {
		
		ResponseEntity<RobotEntity[]> responseEntity =
				   restTemplate.getForEntity(robotSystemUrl, RobotEntity[].class);
		
		RobotEntity [] objects= responseEntity.getBody();
		
		List<RobotEntity> robots = Arrays.stream(objects).filter(robot-> category.equals(robot.getCategory())).collect(Collectors.toList());
		
		LOGGER.info("Robot list based on category:" +category +" size:"+ robots.size());
		
		return robots;
	}

}
