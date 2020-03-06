package com.spring.project.spring.bookshop.service;

import org.springframework.stereotype.Service;

@Service("bookService")
public interface BookService {
    void seedBooks();

    void getBookAfterYear(int year);

    void getAllBooksByAuthorName(String authorName);
}
