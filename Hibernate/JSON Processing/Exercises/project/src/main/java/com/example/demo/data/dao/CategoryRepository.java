package com.example.demo.data.dao;

import com.example.demo.data.entiites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT COUNT(c.id) FROM Category c")
    int getAllCategoriesCount();

    Category findById(long id);

    @Query(value = "SELECT COUNT(p.id) FROM Category c JOIN c.products p " +
            "WHERE c.id = :category_id")
    int getAllProductsCountByCategory(@Param("category_id") long categoryId);

    @Query(value = "SELECT AVG(p.price) FROM Category c JOIN c.products p " +
            "WHERE c.id = :category_id")
    double getAllProductAveragePriceByCategory(@Param("category_id") long categoryId);

    @Query(value = "SELECT SUM(p.price) FROM Category c JOIN c.products p " +
            "WHERE c.id = :category_id")
    double getAllProductRevenuePriceByCategory(@Param("category_id") long categoryId);
}
