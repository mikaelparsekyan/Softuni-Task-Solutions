package com.example.demo.service.impl;

import com.example.demo.constant.FileExportPath;
import com.example.demo.data.dao.SaleRepository;
import com.example.demo.data.entities.Customer;
import com.example.demo.data.entities.Part;
import com.example.demo.data.entities.Sale;
import com.example.demo.dtos.car.CarExportDto;
import com.example.demo.dtos.sale.SaleExportDto;
import com.example.demo.enums.Discount;
import com.example.demo.service.api.CarService;
import com.example.demo.service.api.CustomerService;
import com.example.demo.service.api.SaleService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("saleService")
public class SaleServiceImpl implements SaleService {
    @Autowired
    private final SaleRepository saleRepository;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final Gson gson;

    @Autowired
    private final CarService carService;

    public SaleServiceImpl(CustomerService customerService, SaleRepository saleRepository, ModelMapper modelMapper, Gson gson, CarService carService) {
        this.customerService = customerService;
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;

        this.carService = carService;
    }

    @Override
    public void makeSales() {
        for (int i = 0; i < 100; i++) {
            Customer randomCustomer = customerService.getRandomCustomer();
            Sale sale = new Sale();

            sale.setCustomer(randomCustomer);
            sale.setDiscount(Discount.getRandomDiscount());
            sale.setCar(carService.getRandomCar());

            saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public void exportAllSales() {
        List<SaleExportDto> sales = saleRepository.findAll()
                .stream()
                .map(sale -> {
                    SaleExportDto exportDto = modelMapper
                            .map(sale, SaleExportDto.class);
                    exportDto.setCarExportDto(modelMapper
                            .map(sale.getCar(), CarExportDto.class));

                    exportDto.setDiscount(Double.parseDouble(
                            String.format("%.2f", sale.getDiscount())
                    ));

                    exportDto.setCustomerName(sale.getCustomer().getName());

                    double carPrice = 0;

                    for (Part part : sale.getCar().getParts()) {
                        carPrice += part.getPrice().doubleValue();
                    }

                    exportDto.setPrice(Double.parseDouble(
                            String.format("%.2f", carPrice)
                    ));

                    exportDto.setPriceWithDiscount(carPrice * sale.getDiscount());

                    return exportDto;
                }).collect(Collectors.toList());

        FileUtil.write(FileExportPath.SALE_EXPORT_FILE_PATH,
                gson.toJson(sales));
    }
}
