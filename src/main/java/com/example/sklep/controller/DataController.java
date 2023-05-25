package com.example.sklep.controller;

import com.example.sklep.model.Elevator;
import com.example.sklep.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DataController {

    @Autowired
    private ElevatorService elevatorService;

    @GetMapping("/")
    public String Test() {
        Optional<Elevator> elevator = elevatorService.GetElevator(1L);
        if(elevator.isPresent()) {
            long id = Optional.ofNullable(elevator.get().getId()).get();
            return Integer.toString((int)id);
        }
        return "No games in database";
    }

    @GetMapping("/elevators")
    public List<Elevator> SendGElevators() {
        return elevatorService.GetAllElevators();
    }

}
