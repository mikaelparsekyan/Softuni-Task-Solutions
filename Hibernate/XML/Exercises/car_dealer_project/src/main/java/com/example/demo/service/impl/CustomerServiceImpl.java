package com.example.demo.service.impl;

import com.example.demo.constant.FileExportPath;
import com.example.demo.constant.FileImportPath;
import com.example.demo.data.dao.CustomerRepository;
import com.example.demo.data.entities.Car;
import com.example.demo.data.entities.Customer;
import com.example.demo.data.entities.Part;
import com.example.demo.dtos.export_dtos.customer.CustomerInfoAttributeDto;
import com.example.demo.dtos.export_dtos.customer.CustomerInfoWithElementsDto;
import com.example.demo.dtos.export_dtos.customer.ExportCustomerTotalSalesDto;
import com.example.demo.dtos.export_dtos.customer.ExportCustomersOrderByBirthDateDto;
import com.example.demo.dtos.import_dtos.customer.CustomersImportDto;
import com.example.demo.service.api.CustomerService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
        String file = FileUtil.readFile(FileImportPath.CUSTOMERS_FILE_PATH);

        CustomersImportDto dto = XmlParser.deserialize(file,
                CustomersImportDto.class);

        dto.getCustomers().stream().map(customerSeedDto -> {
            Customer c = modelMapper.map(customerSeedDto, Customer.class);
            c.setBirthDate(LocalDateTime.parse(
                    customerSeedDto.getBirthDate()
                            .trim().replace("T", " "),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            return c;
        }).forEach(customerRepository::saveAndFlush);
    }

    @Override
    public Customer getRandomCustomer() {
        Random random = new Random();
        int allCustomersCount = customerRepository.getAllCustomersCount();

        long randomUserId = random.nextInt(allCustomersCount) + 1;
        return customerRepository.findById(randomUserId);
    }

    @Override
    public void exportAllCustomersOrderByBirthDate() {
        List<CustomerInfoWithElementsDto> customers = customerRepository.findAll()
                .stream()
                .sorted(this::sortCustomers)
                .map(customer -> modelMapper.map(customer,
                        CustomerInfoWithElementsDto.class))
                .collect(Collectors.toList());

        ExportCustomersOrderByBirthDateDto dto = new
                ExportCustomersOrderByBirthDateDto();

        dto.setCustomers(customers);

        XmlParser.serialize(dto, FileExportPath.ORDERED_CUSTOMERS_FILE_PATH);
    }

    private int sortCustomers(Customer c1, Customer c2) {
        int res = c1.getBirthDate()
                .compareTo(c2.getBirthDate());

        if (res == 0) {
            res = Boolean.compare(c1.isYoungDriver(),
                    c2.isYoungDriver());
        }
        return res;
    }

    @Override
    public void exportAllCustomersWithSales() {
        List<CustomerInfoAttributeDto> customers = customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getSale() != null)
                .map(customer -> {
                    CustomerInfoAttributeDto dto = new CustomerInfoAttributeDto();
                    dto.setFullName(customer.getName());

                    Set<Car> customerCars = customerRepository.getAllCarsByCustomer(
                            customer.getId());
                    dto.setSpentMoney(getTotalPriceFromCars(customerCars));
                    dto.setBoughtCars(customerCars.size());
                    return dto;
                })
                .collect(Collectors.toList());

        ExportCustomerTotalSalesDto dto = new ExportCustomerTotalSalesDto();
        dto.setCustomers(customers);

        XmlParser.serialize(dto, FileExportPath.TOTAL_SALES_BY_CUSTOMER_FILE_PATH);
    }

    private double getTotalPriceFromCars(Set<Car> cars) {
        double result = 0;
        for (Car car : cars) {
            for (Part part : car.getParts()) {
                result += part.getPrice().doubleValue();
            }
        }
        return Double.parseDouble(String.format("%.2f", result));
    }
}
