package com.spring.repositories;

import com.spring.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);

    List<Author> getAuthorsByFirstNameEndingWith(String ending);

    @Query(name = "get_amount_of_books_by_name")
    List<Object[]> getBooksCountByFirstNameAndLastName(@Param("first_name") String firstName,
                                            @Param("last_name") String lastName);
}
