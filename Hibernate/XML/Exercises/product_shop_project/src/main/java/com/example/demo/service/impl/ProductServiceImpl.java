package com.example.demo.service.impl;


import com.example.demo.constants.FileImportPaths;
import com.example.demo.data.dao.ProductRepository;
import com.example.demo.dtos.product.ProductImportDto;
import com.example.demo.service.api.CategoryService;
import com.example.demo.service.api.ProductService;
import com.example.demo.service.api.UserService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedProductsToDatabase() {
        String fileXml = FileUtil.readFile(FileImportPaths.PRODUCTS_IMPORT_FILE_PATH);


        ProductImportDto productImportDto = XmlParser.deserialize(fileXml,
                ProductImportDto.class);

        AtomicInteger recordCounter = new AtomicInteger(0);

        productImportDto.getProducts().forEach(
                product -> {
                    recordCounter.incrementAndGet();
                    if (recordCounter.get() % 2 == 0) {
                        product.setBuyer(userService.getRandomUser());
                    }
                    product.setSeller(userService.getRandomUser());
                    product.setCategories(categoryService.getRandomCategories());
                    productRepository.saveAndFlush(product);
                });
    }
}
