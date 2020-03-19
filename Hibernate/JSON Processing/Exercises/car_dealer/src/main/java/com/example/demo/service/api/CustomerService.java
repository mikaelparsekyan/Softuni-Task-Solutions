package com.example.demo.service.api;

import org.springframework.stereotype.Service;

@Service("customerService")
public interface CustomerService {
    void seedCustomersToDatabase();
}
