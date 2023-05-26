package com.example.sklep.controller;

import com.example.sklep.calculations.Calculator;
import com.example.sklep.model.Elevator;
import com.example.sklep.model.Request;
import com.example.sklep.safety.CheckElevator;
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

    @Autowired
    private CheckElevator check;

    @PostMapping("/elevator")
    public ResponseEntity<String> HandleElevatorChange(@RequestBody Elevator elevator) {
        if (check.CheckElevator(elevator)) {
            List<Integer> list = elevator.getAllDestinations();
            list.add(elevator.getCurrentDestination());
            elevator.setAllDestinations(list);
            elevatorService.UpdateElevator(elevator);
            return ResponseEntity.ok("Data received and processed successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("There is no such elevator");
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> HandleNewPerson(@RequestBody Request request) {
        if (check.CheckRequest(request)) {
            calculator.AddPerson(request);
            return ResponseEntity.ok("Data received and processed successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Request cannot be fulfilled");
        }
    }

    @PostMapping("/step")
    public void PerformStep() {
        calculator.Step();
    }

}
