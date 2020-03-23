package com.example.demo.service.impl;

import com.example.demo.data.dao.CustomerRepository;
import com.example.demo.data.entities.Customer;
import com.example.demo.service.api.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomersToDatabase() {

    }

    @Override
    public Customer getRandomCustomer() {
        Random random = new Random();
        int allCustomersCount = customerRepository.getAllCustomersCount();

        long randomUserId = random.nextInt(allCustomersCount) + 1;
        return customerRepository.findById(randomUserId);
    }
}
