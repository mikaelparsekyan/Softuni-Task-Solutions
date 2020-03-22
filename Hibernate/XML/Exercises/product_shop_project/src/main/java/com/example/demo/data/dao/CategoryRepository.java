package com.example.demo.data.dao;

import com.example.demo.data.entiites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT COUNT(c.id) FROM Category c")
    int getAllCategoriesCount();

    Category findById(long id);

}
