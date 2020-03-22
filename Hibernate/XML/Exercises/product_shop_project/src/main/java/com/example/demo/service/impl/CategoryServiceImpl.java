package com.example.demo.service.impl;

import com.example.demo.data.dao.CategoryRepository;
import com.example.demo.data.entiites.Category;
import com.example.demo.service.api.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;

        this.mapper = mapper;
    }

    @Override
    public void seedCategoriesToDatabase() {

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
