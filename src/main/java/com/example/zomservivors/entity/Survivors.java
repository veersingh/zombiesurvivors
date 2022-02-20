package com.example.zomservivors.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Document("Survivors")
public class Survivors implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String name;
	private int age;
	private String gender;
	private Location location;
	private Resources resources;
	private boolean infected=false;
}
