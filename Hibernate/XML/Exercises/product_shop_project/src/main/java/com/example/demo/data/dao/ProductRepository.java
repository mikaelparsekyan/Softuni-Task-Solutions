package com.example.demo.data.dao;

import com.example.demo.data.entiites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductsByPriceIsBetweenAndBuyerIsNull(BigDecimal lowBound,
                                                            BigDecimal topBound);
}
