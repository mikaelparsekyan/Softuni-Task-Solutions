package com.example.demo.service.impl;

import com.example.demo.constant.FileExportPath;
import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.CarRepository;
import com.example.demo.data.entities.Car;
import com.example.demo.data.entities.Part;
import com.example.demo.dtos.export_dtos.car.CarAttributeInfoDto;
import com.example.demo.dtos.export_dtos.car.ExportCarsFromMakeDto;
import com.example.demo.dtos.import_dtos.car.CarsImportDto;
import com.example.demo.service.api.CarService;
import com.example.demo.service.api.PartService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final CarRepository carRepository;
    @Autowired
    private final PartService partService;

    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository, PartService partService) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
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
        String file = FileUtil.readFile(FileImportPath.CARS_FILE_PATH);

        CarsImportDto dto = XmlParser.deserialize(
                file, CarsImportDto.class);

        List<Part> allParts = partService.getAllParts();

        dto.getCars().forEach(car -> {
            car.setParts(partService.getRandomParts(allParts));
            carRepository.saveAndFlush(car);
        });
    }

    @Override
    public void exportAllCarsByMake(String make) {
        List<CarAttributeInfoDto> cars = carRepository
                .getCarsByMake(make)
                .stream()
                .sorted(this::sortCars)
                .map(car -> modelMapper.map(car,
                        CarAttributeInfoDto.class))
                .collect(Collectors.toList());

        ExportCarsFromMakeDto dto = new ExportCarsFromMakeDto();
        dto.setCars(cars);

        XmlParser.serialize(dto, FileExportPath.CARS_FILE_PATH);
    }

    private int sortCars(Car c1, Car c2) {
        int res = c1.getModel().compareTo(c2.getModel());
        if (res == 0) {
            res = Long.compare(c2.getTravelledDistance(),
                    c1.getTravelledDistance());
        }
        return res;
    }

    @Override
    public void exportAllCarsWithParts() {

    }
}
