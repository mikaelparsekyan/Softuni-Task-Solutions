package com.example.demo.runners;

import com.example.demo.service.api.CategoryService;
import com.example.demo.service.api.ProductService;
import com.example.demo.service.api.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AppRunner implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public AppRunner(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedDatabase();

        //Query 1
        //productService.exportAllProductsInRange(new BigDecimal(500),
        //new BigDecimal(1000));

        //Query 2
        //userService.exportAllUsersWithSuccessfullySoldProducts();

        //Query 3
        //categoryService.exportAllCategoriesByProductCount();

        //Query 4
        //userService.exportAllUsersAndProducts();
    }

    private void seedDatabase() {
        userService.seedUsersToDatabase();
        categoryService.seedCategoriesToDatabase();
        productService.seedProductsToDatabase();
    }
}
