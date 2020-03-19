package com.example.demo.service.impl;

import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.CustomerRepository;
import com.example.demo.data.entities.Customer;
import com.example.demo.service.api.CustomerService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final Gson gson;

    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson) {
        this.customerRepository = customerRepository;
        this.gson = gson;
    }

    @Override
    public void seedCustomersToDatabase() {
        String file = FileUtil.readFile(FileImportPath.CUSTOMERS_FILE_PATH);

        List<Customer> customers = gson.fromJson(file, new TypeToken<List<Customer>>() {
        }.getType());

        if (customers != null) {
            customers.forEach(customerRepository::saveAndFlush);
        }
    }
}
