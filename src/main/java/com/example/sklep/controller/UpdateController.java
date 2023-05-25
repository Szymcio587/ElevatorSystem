package com.example.sklep.controller;

import com.example.sklep.calculations.Calculator;
import com.example.sklep.model.Elevator;
import com.example.sklep.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/change")
public class UpdateController {

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private Calculator calculator;

    @PostMapping("/elevator")
    public ResponseEntity<String> HandleElevatorChange(@RequestBody Elevator elevator) {
        if (elevator.getId() >= 0 && elevator.getId() <= 15) {
            List<Integer> list = elevator.getAllDestinations();
            list.add(elevator.getCurrentDestination());
            elevator.setAllDestinations(list);
            elevator.setCurrentDestination(calculator.CalculateDestination(elevator.getFloor(), elevator.getAllDestinations()));
            elevatorService.UpdateElevator(elevator);
            return ResponseEntity.ok("Data received and processed successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("There is no such elevator");
        }
    }
}
