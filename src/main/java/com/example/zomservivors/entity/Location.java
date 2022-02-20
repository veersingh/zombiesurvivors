package com.example.zomservivors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Location {

	private long latitude;
	private long longitude;
}
