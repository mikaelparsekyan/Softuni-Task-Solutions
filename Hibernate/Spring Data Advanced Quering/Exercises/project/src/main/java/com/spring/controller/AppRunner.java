package com.spring.controller;

import com.spring.services.AuthorService;
import com.spring.services.BookService;
import com.spring.services.CategoryService;
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
        /*
            @Warning -> UNCOMMENT TO SEED ALL INFORMATION TO THE DATABASE!
            seedDatabase();
        */
        seedDatabase();

        /*
            TO RUN THE APP, ADJUST THE application.properties file!
            THE APPLICATION DOES NOT CREATE A SCHEMA! IT SHOULD BE CREATED MANUALLY!
            UNCOMMENT THE ROWS BELLOW TO RUN A QUERY
         */

    }

    private void seedDatabase() {
        authorService.seedAuthors();
        categoryService.seedCategory();
        bookService.seedBooks();
    }
}
