package com.spring.services.impls;


import com.spring.constants.AppConstants;
import com.spring.entities.Category;
import com.spring.repositories.CategoryRepository;
import com.spring.services.CategoryService;
import com.spring.util.FileUtil;
import com.spring.util.FileUtilImpl;
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
