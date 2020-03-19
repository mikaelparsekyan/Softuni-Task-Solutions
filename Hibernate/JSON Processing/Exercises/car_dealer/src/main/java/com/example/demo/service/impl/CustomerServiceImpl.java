package com.example.demo.service.impl;

import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.CustomerRepository;
import com.example.demo.data.entities.Customer;
import com.example.demo.dtos.CustomerImportDto;
import com.example.demo.service.api.CustomerService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomersToDatabase() {
        String file = FileUtil.readFile(FileImportPath.CUSTOMERS_FILE_PATH);

        List<CustomerImportDto> customers = gson
                .fromJson(file, new TypeToken<List<CustomerImportDto>>() {
                }.getType());

        if (customers != null) {
            customers.stream().map(this::mapCustomer
            ).forEach(customerRepository::saveAndFlush);
        }
    }

    private Customer mapCustomer(CustomerImportDto customerImportDto) {
        Customer customer = modelMapper.map(customerImportDto, Customer.class);
        customer.setBirthDate(LocalDate.parse(customerImportDto.getBirthDate()
                        .replace("T", " "),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return customer;
    }
}
