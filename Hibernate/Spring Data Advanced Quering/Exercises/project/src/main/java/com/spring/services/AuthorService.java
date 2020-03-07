package com.spring.services;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("authorService")
public interface AuthorService {
    void seedAuthors();

    void getAllAuthorsByEnding(Scanner scanner);

}
