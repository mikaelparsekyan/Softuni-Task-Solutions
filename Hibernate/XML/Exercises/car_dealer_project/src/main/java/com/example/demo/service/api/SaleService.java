package com.example.demo.service.api;

import org.springframework.stereotype.Service;

@Service("saleService")
public interface SaleService {
    void makeSales();

    void exportAllSales();
}
