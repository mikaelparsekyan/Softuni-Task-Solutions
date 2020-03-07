package com.spring.services;

import org.springframework.stereotype.Service;

@Service("authorService")
public interface AuthorService {
    void seedAuthors();

    void getAllAuthorsByEnding(String ending);

}
