package com.spring.controller;

import com.spring.entities.EditionType;
import com.spring.services.AuthorService;
import com.spring.services.BookService;
import com.spring.services.CategoryService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Scanner;

@Controller
public class AppRunner implements CommandLineRunner {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    private Scanner scanner;

    public AppRunner() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
            @Warning -> UNCOMMENT TO SEED ALL INFORMATION TO THE DATABASE!
            seedDatabase();
        */
        //seedDatabase();

        /*
            TO RUN THE APP, ADJUST THE application.properties file!
            THE APPLICATION DOES NOT CREATE A SCHEMA! IT SHOULD BE CREATED MANUALLY!
            UNCOMMENT THE ROWS BELLOW TO RUN A QUERY
         */
        //1. Books Titles by Age Restriction
        //bookService.getBookTitlesByAgeRestriction(scanner);

        //2. Golden Books
        //bookService.getBookTitlesByEditionType(EditionType.GOLD, 5000);

        //3. Books by Price
        //bookService.getBookTitlesAndPricesNotInBound(5, 40);

        //4. Not Released Books
        //bookService.getBookTitlesNotInYear(scanner);

        //5. Books Released Before Date
        //bookService.getBooksByDateBefore(scanner);

        //6. Authors Search
        //authorService.getAllAuthorsByEnding(scanner);

        //7. Books Search
        //bookService.getBooksByContainingText(scanner);

        //8. Book Titles Search
        bookService.getBooksByAuthorLastNameStartingWith(scanner);

        //9. Count Books
        //bookService.getBooksCountByMinLength(scanner);

        //10. Total Book Copies
        //bookService.getCopiesByAuthor();

        //11. Reduced Book
        //bookService.getBookInfoByTitle(scanner);

        //12.* Increase Book Copies
        //bookService.increaseAllBooksByGivenDate(scanner);

        //13. * Remove Books
        //bookService.removeAllBooksWithLowerCountOfCopies(scanner);

        //14. * Stored Procedure
        //bookService.getNumberOfBooksByAuthorName(scanner);

    }

    private void seedDatabase() {
        authorService.seedAuthors();
        categoryService.seedCategory();
        bookService.seedBooks();
    }
}
