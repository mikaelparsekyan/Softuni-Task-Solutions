package com.example.demo.service.impl;

import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.CarRepository;
import com.example.demo.data.entities.Car;
import com.example.demo.service.api.CarService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private final Gson gson;
    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(Gson gson, CarRepository carRepository) {
        this.gson = gson;
        this.carRepository = carRepository;
    }


    @Override
    public void seedCarsToDatabase() {
        String file = FileUtil
                .readFile(FileImportPath.CARS_FILE_PATH);

        List<Car> cars = gson.fromJson(file, new TypeToken<List<Car>>() {
        }.getType());

        if (cars != null) {
            cars.forEach(carRepository::saveAndFlush);
        }
    }
}
