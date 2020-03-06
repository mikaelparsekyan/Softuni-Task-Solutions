package com.spring.project.spring.bookshop.service.impls;

import com.spring.project.spring.bookshop.constants.AppConstants;
import com.spring.project.spring.bookshop.entities.Category;
import com.spring.project.spring.bookshop.repositories.CategoryRepository;
import com.spring.project.spring.bookshop.service.CategoryService;
import com.spring.project.spring.bookshop.util.FileUtil;
import com.spring.project.spring.bookshop.util.FileUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private FileUtil fileUtil;

    public CategoryServiceImpl() {
        this.fileUtil = new FileUtilImpl();
    }

    @Override
    public void seedCategory() {
        String[] categoryData = fileUtil
                .readFile(AppConstants.CATEGORIES_FILE_PATH);

        for (String categoryName : categoryData) {
            categoryRepository.saveAndFlush(new Category(categoryName));
        }
    }
}
