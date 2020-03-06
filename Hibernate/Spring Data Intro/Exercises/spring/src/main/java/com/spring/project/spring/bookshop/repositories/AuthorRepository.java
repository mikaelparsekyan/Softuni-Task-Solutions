package com.spring.project.spring.bookshop.repositories;

import com.spring.project.spring.bookshop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);
}
