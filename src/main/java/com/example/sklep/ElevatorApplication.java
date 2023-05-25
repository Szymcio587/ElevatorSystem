package com.example.sklep;

import com.example.sklep.model.Elevator;
import com.example.sklep.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.LinkedList;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ElevatorApplication implements CommandLineRunner {

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    public ElevatorApplication(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }
    public static void main(String[] args) {
        SpringApplication.run(ElevatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        if(elevatorService.GetAllElevators().isEmpty()) {
            for(int i = 0; i < 16; i++) {
                elevatorService.AddElevator(new Elevator((long)i + 1, 0, 0, new LinkedList<>()));
            }
        }

    }
}
