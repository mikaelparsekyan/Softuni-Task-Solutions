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

        //bookService.getBookTitlesByAgeRestriction(scanner);

        //bookService.getBookTitlesByEditionType(EditionType.GOLD, 5000);

        //bookService.getBookTitlesAndPricesNotInBound(5, 40);

        //bookService.getBookTitlesNotInYear(1998); <-TODO

        //bookService.getBooksByDateBefore(scanner);

        //authorService.getAllAuthorsByEnding(scanner);

        //bookService.getBooksByContainingText(scanner);

        //bookService.getBooksCountByMinLength(scanner);

        //bookService.getBooksCountByAuthorName(); <-TODO

        //bookService.getBookInfoByTitle(scanner);

        //bookService.increaseAllBooksByGivenDate(scanner);

    }

    private void seedDatabase() {
        authorService.seedAuthors();
        categoryService.seedCategory();
        bookService.seedBooks();
    }
}
