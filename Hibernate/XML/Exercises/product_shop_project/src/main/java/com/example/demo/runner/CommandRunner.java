package com.example.demo.runner;

import com.example.demo.service.api.CategoryService;
import com.example.demo.service.api.ProductService;
import com.example.demo.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    private final UserService userService;
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final ProductService productService;

    public CommandRunner(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedDatabase();

        //productService.exportAllProductsByPriceInRange(new BigDecimal(500),
        // new BigDecimal(1000));

        //productService.exportSuccessfullySoldProducts();

        categoryService.exportAllCategories();
    }

    private void seedDatabase() {
        userService.seedUsersToDatabase();
        categoryService.seedCategoriesToDatabase();
        productService.seedProductsToDatabase();
    }
}
