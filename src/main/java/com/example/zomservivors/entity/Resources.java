package com.example.zomservivors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Resources {

	private Long water;
	private Long food;
	private Long ammunition;
	private Long medication;
	
}
