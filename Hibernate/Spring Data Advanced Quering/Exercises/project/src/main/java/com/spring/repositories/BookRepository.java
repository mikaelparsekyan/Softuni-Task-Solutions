package com.spring.repositories;

import com.spring.entities.AgeRestriction;
import com.spring.entities.Book;
import com.spring.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> getBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lowBoundPrice, BigDecimal topBoundPrice);
}
