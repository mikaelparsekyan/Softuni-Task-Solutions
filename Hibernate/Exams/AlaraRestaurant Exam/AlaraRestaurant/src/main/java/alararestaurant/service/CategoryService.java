package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    String exportCategoriesByCountOfItems();

    Category getCategoryByName(String name);
}
