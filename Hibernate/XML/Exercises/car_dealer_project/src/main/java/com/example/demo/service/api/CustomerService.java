package com.example.demo.service.api;

import com.example.demo.data.entities.Customer;
import org.springframework.stereotype.Service;


@Service("customerService")
public interface CustomerService {
    Customer getRandomCustomer();

    void seedCustomersToDatabase();

    void exportAllCustomersOrderByBirthDate();

    void exportAllCustomersWithSales();
}
