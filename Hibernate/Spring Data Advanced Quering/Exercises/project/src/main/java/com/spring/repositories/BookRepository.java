package com.spring.repositories;

import com.spring.entities.AgeRestriction;
import com.spring.entities.Book;
import com.spring.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> getBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lowBoundPrice,
                                                         BigDecimal topBoundPrice);

    @Query(value = "SELECT b FROM Book b WHERE YEAR(b.releaseDate) <> :year")
    List<Book> getBooksByNotInRealiseDate(@Param("year") int year);//TODO

    List<Book> getBooksByReleaseDateBefore(LocalDate date);

    List<Book> getBooksByTitleContains(String text);

    List<Book> getBooksByAuthorLastNameStartsWith(String startStr);

    @Query("SELECT COUNT(b.id) FROM Book b WHERE length(b.title) > :minTitleLen")
    int countBooksByTitle(@Param("minTitleLen") int minTitleLen);

    @Query(value = "SELECT a.firstName, a.lastName, SUM(b.copies) AS sum_copies FROM Book b JOIN b.author a " +
            "GROUP BY a.id ORDER BY sum_copies DESC")
    List<Object[]> getBooksCopiesWithAuthorName();

    @Query("SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book b" +
            " WHERE b.title = :title")
    List<Object[]> getBooksInfo(@Param("title") String title);

    List<Book> getBooksByReleaseDateAfter(LocalDate date);

    @Modifying
    @Query("DELETE FROM Book b WHERE b.copies < :copies")
    void deleteBooksByCopies(@Param("copies") int copies);
}
