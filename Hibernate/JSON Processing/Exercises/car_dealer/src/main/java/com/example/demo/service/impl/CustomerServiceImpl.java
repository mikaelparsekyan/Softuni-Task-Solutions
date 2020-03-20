package com.example.demo.service.impl;

import com.example.demo.constant.FileExportPath;
import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.CustomerRepository;
import com.example.demo.data.entities.Customer;
import com.example.demo.dtos.customer.CustomerImportDto;
import com.example.demo.dtos.customer.CustomerOrderExportDto;
import com.example.demo.service.api.CustomerService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    @Override
    public Customer getRandomCustomer() {
        Random random = new Random();
        int allCustomersCount = customerRepository.getAllCustomersCount();

        long randomUserId = random.nextInt(allCustomersCount) + 1;
        return customerRepository.findById(randomUserId);
    }

    private Customer mapCustomer(CustomerImportDto customerImportDto) {
        Customer customer = modelMapper.map(customerImportDto, Customer.class);
        customer.setBirthDate(LocalDateTime.parse(
                customerImportDto.getBirthDate().replace("T", " "),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
        return customer;
    }

    @Override
    public void exportAllCustomersOrderedByBirthdate() {
        List<CustomerOrderExportDto> customers = customerRepository.findAll()
                .stream()
                .sorted((c1, c2) -> {
                    int result = c1.getBirthDate()
                            .compareTo(c2.getBirthDate());
                    if (result == 0) {
                        result = Boolean.compare(c1.isYoungDriver(),
                                c2.isYoungDriver());
                    }
                    return result;
                })
                .map(customer -> {
                    CustomerOrderExportDto exportDto =
                            modelMapper.map(customer, CustomerOrderExportDto.class);
                    exportDto.setBirthDate(customer.getBirthDate()
                            .format(DateTimeFormatter.ofPattern(
                                    "yyyy-MM-dd HH:mm:ss"))
                            .replace(" ", "T"));
                    return exportDto;
                }).collect(Collectors.toList());

        FileUtil.write(FileExportPath.ORDERED_CUSTOMERS_FILE_PATH,
                gson.toJson(customers));
    }
}
