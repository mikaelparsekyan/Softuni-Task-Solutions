package com.spring.services.impls;


import com.spring.constants.AppConstants;
import com.spring.entities.Author;
import com.spring.entities.Book;
import com.spring.repositories.AuthorRepository;
import com.spring.services.AuthorService;
import com.spring.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static com.spring.constants.AppConstants.PRINT_AUTHOR_INFORMATION;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    private FileUtil fileUtil;

    public AuthorServiceImpl(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() {
        String[] authorData = fileUtil
                .readFile(AppConstants.AUTHORS_FILE_PATH);
        for (String data : authorData) {
            authorRepository.saveAndFlush(getAuthorByData(data));
        }
    }

    @Override
    public void getAllAuthorsByEnding(Scanner scanner) {
        System.out.println("Enter ending string: ");

        authorRepository
                .getAuthorsByFirstNameEndingWith(scanner.nextLine())
                .forEach(author -> System.out.printf(PRINT_AUTHOR_INFORMATION,
                        author.getFirstName(), author.getLastName()));
    }

    private Author getAuthorByData(String data) {
        String[] elements = data.split("\\s+");

        String firstName = elements[0];
        String lastName = elements[1];

        return new Author(firstName, lastName);
    }
}
