package com.example.demo.service.api;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ProductService {
    void seedProductsToDatabase();

    void exportAllProductsByPriceInRange(BigDecimal lowBound, BigDecimal topBound);

    void exportSuccessfullySoldProducts();
}
