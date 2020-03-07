package com.spring.repositories;

import com.spring.entities.AgeRestriction;
import com.spring.entities.Book;
import com.spring.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> getBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lowBoundPrice,
                                                         BigDecimal topBoundPrice);

    //List<Book> queryBookByReleaseDate_YearNot(int year);

    List<Book> getBooksByReleaseDateBefore(LocalDate date);

    List<Book> getBooksByTitleContains(String text);

    @Query("SELECT COUNT(b.id) FROM Book b WHERE length(b.title) > :minTitleLen")
    int countBooksByTitle(@Param("minTitleLen") int minTitleLen);
}
