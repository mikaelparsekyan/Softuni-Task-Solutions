package com.example.demo.init;

import com.example.demo.service.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private final CarService carService;

    public Runner(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
