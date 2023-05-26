package com.example.sklep.calculations;

import com.example.sklep.model.Elevator;
import com.example.sklep.model.Request;
import com.example.sklep.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;

@Component
public class Calculator {

    @Autowired
    private ElevatorService elevatorService;

    public int CalculateDestination(Elevator elevator) {
        List<Integer> destinations = elevator.getAllDestinations();

        if(destinations.isEmpty())
            return(elevator.getFloor());

        destinations.sort(null);
        elevator.setAllDestinations(destinations);
        int closer = (Math.abs((elevator.getFloor() - destinations.get(0))) <= Math.abs((destinations.get(destinations.size() - 1) - elevator.getFloor()))) ? 1 : -1;
        int destination = -1;
        if(closer == 1) {
            for(Integer floor : destinations) {
                if(floor < elevator.getFloor())
                    destination = floor;
                else
                    break;
            }
            if(destination == -1)
                destination = destinations.get(0);
        }

        else {
            for(Integer floor : destinations) {
                if(floor > elevator.getFloor()) {
                    destination = floor;
                    break;
                }
            }
            if(destination == -1)
                destination = destinations.get(destinations.size() - 1);
        }


        return destination;
    }

    public void AddPerson(Request request) {
        List<Elevator> elevators = elevatorService.GetAllElevators();
        int distance = Math.abs(request.getFloor() - elevators.get(0).getFloor());
        Elevator target = elevators.get(0);
        for(Elevator elevator : elevators) {
            if((Math.abs(request.getFloor() - elevator.getFloor())) < distance ||
               (Math.abs(request.getFloor() - elevator.getFloor()) == distance &&
                elevator.getAllDestinations().size() < target.getAllDestinations().size())) {
                distance = (Math.abs(request.getFloor() - elevator.getFloor()));
                target = elevator;
            }
        }
        if(target.getAllDestinations().stream().anyMatch(floor -> floor == request.getDestination()))
            return;
        target.AddDestination(request.getDestination());
        target.setCurrentDestination(request.getFloor());
        elevatorService.UpdateElevator(target);
    }

    public void Step() {
        List<Elevator> elevators = elevatorService.GetAllElevators();
        for(Elevator elevator : elevators) {
            if(elevator.getFloor() > elevator.getCurrentDestination())
                elevator.setFloor(elevator.getFloor() - 1);
            else if(elevator.getFloor() < elevator.getCurrentDestination())
                elevator.setFloor(elevator.getFloor() + 1);
            else {
                List<Integer> list = elevator.getAllDestinations();
                list.removeAll(Arrays.asList(elevator.getCurrentDestination()));
                elevator.setAllDestinations(list);
                elevator.setCurrentDestination(CalculateDestination(elevator));
            }

            elevatorService.UpdateElevator(elevator);
        }
    }
}
