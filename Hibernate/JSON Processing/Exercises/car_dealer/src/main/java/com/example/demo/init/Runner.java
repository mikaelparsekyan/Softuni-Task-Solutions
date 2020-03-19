package com.example.demo.init;

import com.example.demo.service.api.CarService;
import com.example.demo.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private final CarService carService;
    @Autowired
    private final CustomerService customerService;

    public Runner(CarService carService, CustomerService customerService) {
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {
        //carService.seedCarsToDatabase();
        customerService.seedCustomersToDatabase();
    }
}
