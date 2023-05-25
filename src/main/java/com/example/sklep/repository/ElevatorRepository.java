package com.example.sklep.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElevatorRepository extends MongoRepository<com.example.sklep.model.Elevator, Long> {
}
