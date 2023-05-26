package com.example.sklep.safety;

import com.example.sklep.model.Elevator;
import com.example.sklep.model.Request;
import org.springframework.stereotype.Component;

@Component
public class CheckElevator {

    public boolean CheckElevator(Elevator elevator) {
        if(elevator.getId() >= 0 && elevator.getId() <= 15 &&
           elevator.getFloor() >= 0 && elevator.getFloor() <= 15 &&
           elevator.getCurrentDestination() >= 0 && elevator.getCurrentDestination() <= 15)
            return true;
        else
            return false;
    }

    public boolean CheckRequest(Request request) {
        if(request.getFloor() >= 0 && request.getFloor() <= 15 &&
           request.getDestination() >= 0 && request.getDestination() <= 15)
            return true;
        else
            return false;
    }
}
