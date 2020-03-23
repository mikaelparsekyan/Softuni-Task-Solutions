package com.example.demo.service.api;

import com.example.demo.data.entities.Car;
import org.springframework.stereotype.Service;

@Service("carService")
public interface CarService {
    Car getRandomCar();

    void seedCarsToDatabase();

    void exportAllCarsByMake(String make);

    void exportAllCarsWithParts();
}
