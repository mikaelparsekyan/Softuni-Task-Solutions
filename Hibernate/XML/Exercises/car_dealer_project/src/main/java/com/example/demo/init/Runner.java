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
        //Query 1
        //customerService.exportAllCustomersOrderByBirthDate();
        //Query 2
        //carService.exportAllCarsByMake("Toyota");
        //Query 3
        //supplierService.exportAllLocalSuppliers();
        //Query 4
        //carService.exportAllCarsWithParts();
        //Query 5
        //customerService.exportAllCustomersWithSales();
        //Query 6
        saleService.exportAllSales();
    }

    private void seedDatabase() {
        System.out.println("Seeding information... ");
        supplierService.seedSuppliersToDatabase();
        partService.seedPartsToDatabase();
        carService.seedCarsToDatabase();
        customerService.seedCustomersToDatabase();
        saleService.makeSales();
        System.out.println("Seeding finished!");
    }
}
