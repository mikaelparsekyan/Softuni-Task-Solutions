package com.example.demo.service.impl;


import com.example.demo.constants.FileExportPaths;
import com.example.demo.constants.FileImportPaths;
import com.example.demo.data.dao.ProductRepository;
import com.example.demo.data.entiites.Product;
import com.example.demo.data.entiites.User;
import com.example.demo.dtos.product.*;
import com.example.demo.dtos.user.UserSoldProductsExportDto;
import com.example.demo.dtos.user.UserWithProductsExportDto;
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
import java.util.function.Predicate;
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
        dto.setSeller((sellerFirstName == null ? "" : sellerFirstName + " ") +
                sellerLastName
        );
        return dto;
    }

    @Override
    public void exportSuccessfullySoldProducts() {
        UserSoldProductsExportDto soldProducts = new UserSoldProductsExportDto();

        List<UserWithProductsExportDto> users = userService
                .getAllUsers()
                .stream()
                .filter(filterUsersByProductsCount())
                .sorted(this::sortUsersByName)
                .map(this::mapUsersWithProducts)
                .collect(Collectors.toList());

        soldProducts.setUsers(users);

        XmlParser.serialize(soldProducts,
                FileExportPaths.SUCCESSFULLY_SOLD_PRODUCTS_FILE_PATH);
    }

    private UserWithProductsExportDto mapUsersWithProducts(User user) {
        UserWithProductsExportDto productsExportDto = modelMapper
                .map(user, UserWithProductsExportDto.class);

        productsExportDto.setFirstName(user.getFirstName());
        productsExportDto.setLastName(user.getLastName());

        List<ProductInfoByElementsDto> products = user.getProducts()
                .stream()
                .filter(product ->
                        product.getBuyer() != null
                )
                .map(product -> modelMapper.map(product,
                        ProductInfoByElementsDto.class
                ))
                .collect(Collectors.toList());
        productsExportDto.setSoldProductsExportDto(
                new SoldProductsExportDto(products));
        return productsExportDto;
    }

    private Predicate<User> filterUsersByProductsCount() {
        return user -> user.getProducts().stream().filter(product ->
                product.getBuyer() != null).count() >= 1;
    }

    private int sortUsersByName(User u1, User u2) {
        int result = u1.getLastName().compareTo(u2.getLastName());
        String firstUserName = u1.getFirstName();
        String secondUserName = u2.getFirstName();
        if (result == 0 && firstUserName != null && secondUserName != null) {
            result = u1.getFirstName().compareTo(u2.getFirstName());
        }
        return result;
    }
}
