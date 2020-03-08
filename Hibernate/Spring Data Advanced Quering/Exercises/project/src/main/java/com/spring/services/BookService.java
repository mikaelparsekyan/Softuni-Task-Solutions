package com.spring.services;

import com.spring.entities.EditionType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Scanner;

@Service("bookService")
public interface BookService {
    void seedBooks();

    void getBookTitlesByAgeRestriction(Scanner scanner);

    void getBookTitlesByEditionType(EditionType editionType, int copies);

    void getBookTitlesAndPricesNotInBound(double lowBoundPrice, double topBoundPrice);

    void getBookTitlesNotInYear(Scanner scanner);

    void getBooksByDateBefore(Scanner scanner);

    void getBooksByContainingText(Scanner scanner);

    void getBooksCountByMinLength(Scanner scanner);

    void getBooksCountByAuthorName();

    void getBookInfoByTitle(Scanner scanner);

    void increaseAllBooksByGivenDate(Scanner scanner);

    void removeAllBooksWithLowerCountOfCopies(int copies);
}
