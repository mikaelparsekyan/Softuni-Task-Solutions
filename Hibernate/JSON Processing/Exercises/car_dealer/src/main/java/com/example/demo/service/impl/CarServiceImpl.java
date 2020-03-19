package com.example.demo.service.impl;

import com.example.demo.service.api.CarService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private final Gson gson;

    public CarServiceImpl(Gson gson) {
        this.gson = gson;
    }


}
