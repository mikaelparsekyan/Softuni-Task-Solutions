package com.spring.services;

import org.springframework.stereotype.Service;

@Service("bookService")
public interface BookService {
    void seedBooks();
}
