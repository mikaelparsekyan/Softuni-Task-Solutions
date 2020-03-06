package com.spring.project.spring.bookshop.service;

import org.springframework.stereotype.Service;

@Service("authorService")
public interface AuthorService {
    void seedAuthors();

    void getAuthorWithMinNumberOfBooks(int bookNumber, int releaseYear);

    void getAllAuthorsOrderByNumberOfBooks();

}
