package com.example.zomservivors.service;

import java.util.List;

import com.example.zomservivors.entity.RobotEntity;

public interface RobotService {

	public List<RobotEntity> getRobots();
	public List<RobotEntity> getRobotsByCategory(String category);
}
