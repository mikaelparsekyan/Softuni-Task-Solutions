package com.example.demo.service.impl;

import com.example.demo.data.dao.SaleRepository;
import com.example.demo.data.entities.Customer;
import com.example.demo.data.entities.Sale;
import com.example.demo.enums.Discount;
import com.example.demo.service.api.CarService;
import com.example.demo.service.api.CustomerService;
import com.example.demo.service.api.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("saleService")
public class SaleServiceImpl implements SaleService {
    @Autowired
    private final SaleRepository saleRepository;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final CarService carService;

    public SaleServiceImpl(CustomerService customerService, SaleRepository saleRepository, CarService carService) {
        this.customerService = customerService;
        this.saleRepository = saleRepository;
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
}
