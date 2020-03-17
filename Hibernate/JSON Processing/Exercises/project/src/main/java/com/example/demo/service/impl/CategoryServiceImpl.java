package com.example.demo.service.impl;

import com.example.demo.data.dao.CategoryRepository;
import com.example.demo.data.entiites.Category;
import com.example.demo.service.api.CategoryService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final Gson gson;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
    }

    @Override
    public void seedCategoriesToDatabase() {
        String fileText = FileUtil
                .readFile("src/main/resources/files/categories.json");
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
}
