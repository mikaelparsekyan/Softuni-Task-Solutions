package com.example.demo.service.impl;

import com.example.demo.constants.FileExportPaths;
import com.example.demo.constants.FileImportPaths;
import com.example.demo.data.dao.CategoryRepository;
import com.example.demo.data.entiites.Category;
import com.example.demo.dtos.category.CategoryExportDto;
import com.example.demo.service.api.CategoryService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final Gson gson;
    @Autowired
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public void seedCategoriesToDatabase() {
        String fileText = FileUtil
                .readFile(FileImportPaths.CATEGORIES_IMPORT_FILE_PATH);
        List<Category> categories = gson.fromJson(fileText,
                new TypeToken<List<Category>>() {
                }.getType());

        if (categories != null) {
            categories.forEach(categoryRepository::saveAndFlush);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {
        List<Category> categories = new ArrayList<>();
        Random random = new Random();
        int categoriesCount = categoryRepository.getAllCategoriesCount();

        for (int i = 0; i < 2; i++) {
            long categoryId = random.nextInt(categoriesCount) + 1;
            categories.add(categoryRepository.findById(categoryId));
        }
        return new HashSet<>(categories);
    }

    @Override
    public void exportAllCategoriesByProductCount() {
        List<CategoryExportDto> categories = categoryRepository
                .findAll()
                .stream()
                .map(this::mapCategoryFields)
                .sorted((c1, c2) -> Integer.compare(c2.getProductsCount(),
                        c1.getProductsCount()))
                .collect(Collectors.toList());

        FileUtil.write(FileExportPaths.CATEGORY_EXPORT_FILE_PATH,
                gson.toJson(categories));
    }

    private CategoryExportDto mapCategoryFields(Category category) {
        CategoryExportDto dto = mapper
                .map(category, CategoryExportDto.class);

        dto.setProductsCount(categoryRepository
                .getAllProductsCountByCategory(category.getId()));

        dto.setAveragePrice(new BigDecimal(
                String.format("%.6f", categoryRepository
                        .getAllProductAveragePriceByCategory(
                                category.getId()))));

        dto.setTotalRevenue(new BigDecimal(
                String.format("%.6f", categoryRepository
                        .getAllProductRevenuePriceByCategory(
                                category.getId()))));

        return dto;
    }
}
