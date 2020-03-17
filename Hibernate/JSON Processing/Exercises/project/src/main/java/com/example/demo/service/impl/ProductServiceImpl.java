package com.example.demo.service.impl;

import com.example.demo.data.dao.ProductRepository;
import com.example.demo.data.entiites.Category;
import com.example.demo.data.entiites.Product;
import com.example.demo.service.api.CategoryService;
import com.example.demo.service.api.ProductService;
import com.example.demo.service.api.UserService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final UserService userService;
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, Gson gson, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedProductsToDatabase() {
        String fileText = FileUtil.readFile("src/main/resources/files/products.json");
        List<Product> products = gson.fromJson(fileText,
                new TypeToken<List<Product>>() {
                }.getType());

        if (products != null) {
            AtomicInteger count = new AtomicInteger();
            products.forEach(product -> {
                count.getAndIncrement();
                product.setSeller(userService.getRandomUser());
                if (count.get() % 2 == 0) {
                    product.setBuyer(userService.getRandomUser());
                }
                product.setCategories(categoryService.getRandomCategories());
            });
            products.forEach(productRepository::saveAndFlush);
        }
    }

    @Override
    public void exportAllProductsInRange(BigDecimal min, BigDecimal max) {
        List<Product> products = productRepository
                .getProductsByPriceIsBetween(min, max);

        String fileOutputPath = "src/main/resources/export/products-in-range.json";

        FileUtil.write(fileOutputPath, gson.toJson(products));
    }
}
