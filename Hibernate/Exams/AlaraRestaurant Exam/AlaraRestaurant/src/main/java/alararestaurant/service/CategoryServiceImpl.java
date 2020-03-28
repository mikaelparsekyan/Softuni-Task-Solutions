package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String exportCategoriesByCountOfItems() {
        // TODO : Implement me
        return "";
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.getByName(name);
    }
}
