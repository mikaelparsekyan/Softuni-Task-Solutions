package com.example.demo.service.impl;

import com.example.demo.constant.FileExportPath;
import com.example.demo.data.dao.SaleRepository;
import com.example.demo.data.entities.Customer;
import com.example.demo.data.entities.Part;
import com.example.demo.data.entities.Sale;
import com.example.demo.dtos.export_dtos.sale.ExportSalesWithInfoDto;
import com.example.demo.dtos.export_dtos.sale.SaleCarInfoDto;
import com.example.demo.enums.Discount;
import com.example.demo.service.api.CarService;
import com.example.demo.service.api.CustomerService;
import com.example.demo.service.api.SaleService;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("saleService")
public class SaleServiceImpl implements SaleService {
    @Autowired
    private final SaleRepository saleRepository;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final CarService carService;

    public SaleServiceImpl(CustomerService customerService, SaleRepository saleRepository, ModelMapper modelMapper, CarService carService) {
        this.customerService = customerService;
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.carService = carService;
    }

    @Override
    public void makeSales() {
        for (int i = 0; i < 5; i++) {
            Customer randomCustomer = customerService.getRandomCustomer();
            Sale sale = new Sale();

            sale.setCustomer(randomCustomer);
            sale.setDiscount(Discount.getRandomDiscount());
            sale.setCar(carService.getRandomCar());

            saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public void exportAllSales() {
        List<SaleCarInfoDto> sales = saleRepository.findAll()
                .stream()
                .map(sale -> {
                    SaleCarInfoDto saleCarInfoDto = modelMapper.
                            map(sale, SaleCarInfoDto.class);
                    saleCarInfoDto.setPrice(getPriceBySale(sale));
                    saleCarInfoDto.setPriceWithDiscount(
                            getPriceBySale(sale) * sale.getDiscount());
                    return saleCarInfoDto;
                })
                .collect(Collectors.toList());


        ExportSalesWithInfoDto dto = new ExportSalesWithInfoDto();
        dto.setSales(sales);
        XmlParser.serialize(dto, FileExportPath.SALE_EXPORT_FILE_PATH);
    }

    private double getPriceBySale(Sale sale) {
        double result = 0;
        for (Part part : sale.getCar().getParts()) {
            result += part.getPrice().doubleValue();
        }
        return result;
    }
}
