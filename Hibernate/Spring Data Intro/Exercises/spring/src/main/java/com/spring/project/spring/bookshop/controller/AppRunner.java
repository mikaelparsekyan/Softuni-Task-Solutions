package com.spring.project.spring.bookshop.controller;

import com.spring.project.spring.bookshop.service.AuthorService;
import com.spring.project.spring.bookshop.service.BookService;
import com.spring.project.spring.bookshop.service.CategoryService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
@NoArgsConstructor
public class AppRunner implements CommandLineRunner {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;


    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
        /*
            TO RUN THE APP, ADJUST THE application.properties file!
            THE APPLICATION DOES NOT CREATE A SCHEMA! IT SHOULD BE CREATED MANUALLY!
            UNCOMMENT THE ROWS BELLOW TO RUN A QUERY
            SECOND TASK IS NOT INCLUDED IN THE FINAL SCORE!
         */

        bookService.getBookAfterYear(2000);

        //authorService.getAuthorWithMinNumberOfBooks(1, 1990);

        //authorService.getAllAuthorsOrderByNumberOfBooks();

        //bookService.getAllBooksByAuthorName("George Powell");
    }

    private void seedDatabase() {
        authorService.seedAuthors();
        categoryService.seedCategory();
        bookService.seedBooks();
    }
}
