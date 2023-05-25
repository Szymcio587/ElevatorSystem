package com.example.sklep.service;

import com.example.sklep.model.Elevator;
import com.example.sklep.repository.ElevatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElevatorService {
@Autowired
ElevatorRepository elevatorRepository;

    public Optional<Elevator> GetElevator(Long id) {
        return elevatorRepository.findById(id);
    }

    public List<Elevator> GetAllElevators() {
        return elevatorRepository.findAll();
    }

    public void AddElevator(Elevator elevator) {
        elevatorRepository.save(elevator);
    }

    public void UpdateElevator(Elevator elevator) {
        if(this.GetElevator(elevator.getId()).isPresent()) {
            elevatorRepository.save(elevator);
        }
    }

}
