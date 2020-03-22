package com.example.demo.service.impl;


import com.example.demo.constants.FileExportPaths;
import com.example.demo.constants.FileImportPaths;
import com.example.demo.data.dao.ProductRepository;
import com.example.demo.data.entiites.Product;
import com.example.demo.dtos.product.ProductElementInfoDto;
import com.example.demo.dtos.product.ProductImportDto;
import com.example.demo.dtos.product.ProductsInRangeExportDto;
import com.example.demo.service.api.CategoryService;
import com.example.demo.service.api.ProductService;
import com.example.demo.service.api.UserService;
import com.example.demo.util.FileUtil;
import com.example.demo.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
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

    @Override
    public void exportAllProductsByPriceInRange(BigDecimal lowBound, BigDecimal topBound) {
        List<ProductElementInfoDto> products = productRepository
                .getProductsByPriceIsBetweenAndBuyerIsNull(lowBound, topBound)
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .map(this::mapProducts)
                .collect(Collectors.toList());

        ProductsInRangeExportDto productsExportDto = new ProductsInRangeExportDto();
        productsExportDto.setProducts(products);

        XmlParser.serialize(productsExportDto,
                FileExportPaths.PRODUCTS_IN_RANGE_EXPORT_FILE_PATH);
    }

    private ProductElementInfoDto mapProducts(Product product) {
        ProductElementInfoDto dto = modelMapper
                .map(product, ProductElementInfoDto.class);
        dto.setPrice(product.getPrice().doubleValue());
        String sellerFirstName = product.getSeller().getFirstName();
        String sellerLastName = product.getSeller().getLastName();
        dto.setSeller((sellerFirstName == null ? "" : sellerFirstName + " ")  +
                sellerLastName
        );
        return dto;
    }
}
