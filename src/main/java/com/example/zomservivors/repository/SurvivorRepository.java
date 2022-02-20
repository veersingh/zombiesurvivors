package com.example.zomservivors.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.zomservivors.entity.Survivors;

public interface SurvivorRepository extends MongoRepository<Survivors, String> {

}
