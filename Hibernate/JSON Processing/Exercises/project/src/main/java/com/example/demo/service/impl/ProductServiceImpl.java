package com.example.demo.service.impl;

import com.example.demo.constants.FileExportPaths;
import com.example.demo.constants.FileImportPaths;
import com.example.demo.data.dao.ProductRepository;
import com.example.demo.data.entiites.Category;
import com.example.demo.data.entiites.Product;
import com.example.demo.data.entiites.User;
import com.example.demo.dtos.product.ProductInRangeExportDto;
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
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        String fileText = FileUtil
                .readFile(FileImportPaths.PRODUCTS_IMPORT_FILE_PATH);
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
        List<ProductInRangeExportDto> products = productRepository
                .getProductsByPriceIsBetween(min, max)
                .stream()
                .map(product -> {

                    ProductInRangeExportDto dto = modelMapper.map(
                            product, ProductInRangeExportDto.class);

                    User currentSeller = product.getSeller();

                    dto.setSeller((currentSeller.getFirstName() == null ? "" :
                            currentSeller.getFirstName() + " ") +
                            currentSeller.getLastName());

                    return dto;

                }).sorted(Comparator.comparing(ProductInRangeExportDto::getPrice))
                .collect(Collectors.toList());


        String fileOutputPath = FileExportPaths.PRODUCTS_IN_RANGE_EXPORT_FILE_PATH;

        FileUtil.write(fileOutputPath, gson.toJson(products));
    }
}
