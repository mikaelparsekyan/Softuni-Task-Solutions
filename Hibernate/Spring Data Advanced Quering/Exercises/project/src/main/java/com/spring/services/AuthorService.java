package com.spring.services;

import org.springframework.stereotype.Service;

@Service("authorService")
public interface AuthorService {
    void seedAuthors();

    void getAuthorWithMinNumberOfBooks(int bookNumber, int releaseYear);

    void getAllAuthorsOrderByNumberOfBooks();

}
