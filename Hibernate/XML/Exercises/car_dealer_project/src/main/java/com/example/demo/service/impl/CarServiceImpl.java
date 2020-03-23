package com.example.demo.service.impl;

import com.example.demo.data.dao.CarRepository;
import com.example.demo.data.entities.Car;
import com.example.demo.service.api.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
    }


    @Override
    public Car getRandomCar() {
        Random random = new Random();
        int randomCarId = random.nextInt(carRepository.getAllCarsCount()) + 1;
        return carRepository.findById(randomCarId);
    }

    @Override
    public void seedCarsToDatabase() {
    }

    @Override
    public void exportAllCarsByMake(String make) {

    }

    @Override
    public void exportAllCarsWithParts() {

    }
}
