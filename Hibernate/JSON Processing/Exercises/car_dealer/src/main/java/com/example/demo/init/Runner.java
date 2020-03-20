package com.example.demo.init;

import com.example.demo.service.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private final CarService carService;
    @Autowired
    private final SupplierService supplierService;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final PartService partService;
    @Autowired
    private final SaleService saleService;

    public Runner(CarService carService, SupplierService supplierService, CustomerService customerService, PartService partService, SaleService saleService) {
        this.carService = carService;
        this.supplierService = supplierService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedDatabase();
        //customerService.exportAllCustomersOrderedByBirthdate();
        //carService.exportAllCarsByMake("Toyota");
        //supplierService.exportAllSuppliersNotImportFromAbroad();

    }

    private void seedDatabase() {
        System.out.println("Seeding information... " +
                "It will take about a minute");
        supplierService.seedSuppliersToDatabase();
        partService.seedPartsToDatabase();
        carService.seedCarsToDatabase();
        customerService.seedCustomersToDatabase();
        saleService.makeSales();
        System.out.println("Seeding finished!");
    }
}
