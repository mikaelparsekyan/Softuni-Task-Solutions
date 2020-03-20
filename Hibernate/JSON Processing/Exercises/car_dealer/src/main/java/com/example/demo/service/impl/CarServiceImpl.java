package com.example.demo.service.impl;

import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.CarRepository;
import com.example.demo.data.dao.PartRepository;
import com.example.demo.data.entities.Car;
import com.example.demo.data.entities.Part;
import com.example.demo.service.api.CarService;
import com.example.demo.service.api.PartService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private final Gson gson;
    @Autowired
    private final CarRepository carRepository;
    @Autowired
    private final PartRepository partRepository;
    @Autowired
    private final PartService partService;

    public CarServiceImpl(Gson gson, CarRepository carRepository, PartRepository partRepository, PartService partService) {
        this.gson = gson;
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.partService = partService;
    }


    @Override
    public Car getRandomCar() {
        Random random = new Random();
        int randomCarId = random.nextInt(carRepository.getAllCarsCount()) + 1;
        return carRepository.findById(randomCarId);
    }

    @Override
    public void seedCarsToDatabase() {
        String file = FileUtil
                .readFile(FileImportPath.CARS_FILE_PATH);

        List<Part> allParts = partRepository.findAll();

        List<Car> cars = gson.fromJson(file, new TypeToken<List<Car>>() {
        }.getType());

        if (cars != null) {
            cars.forEach(car -> {
                car.setParts(partService.getRandomParts(allParts));
                carRepository.saveAndFlush(car);
            });
        }
    }
}
