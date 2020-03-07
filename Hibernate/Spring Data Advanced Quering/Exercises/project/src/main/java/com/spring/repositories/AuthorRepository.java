package com.spring.repositories;

import com.spring.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);

    List<Author> getAuthorsByFirstNameEndingWith(String ending);
}
