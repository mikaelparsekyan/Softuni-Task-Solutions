package com.spring.services;

import com.spring.entities.AgeRestriction;
import com.spring.entities.EditionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("bookService")
public interface BookService {
    void seedBooks();

    void getBookTitlesByAgeRestriction(String ageRestrictionValue);

    void getBookTitlesByEditionType(EditionType editionType, int copies);

    void getBookTitlesAndPricesNotInBound(double lowBoundPrice, double topBoundPrice);
}
