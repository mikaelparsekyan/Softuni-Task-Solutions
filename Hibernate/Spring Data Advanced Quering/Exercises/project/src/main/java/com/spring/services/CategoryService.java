package com.spring.services;

import org.springframework.stereotype.Service;

@Service("categoryService")
public interface CategoryService {
    void seedCategory();
}
