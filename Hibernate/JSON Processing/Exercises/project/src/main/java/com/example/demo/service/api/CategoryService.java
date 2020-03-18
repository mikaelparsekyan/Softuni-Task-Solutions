package com.example.demo.service.api;

import com.example.demo.data.entiites.Category;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CategoryService {
    void seedCategoriesToDatabase();

    Set<Category> getRandomCategories();

    void exportAllCategoriesByProductCount();
}
