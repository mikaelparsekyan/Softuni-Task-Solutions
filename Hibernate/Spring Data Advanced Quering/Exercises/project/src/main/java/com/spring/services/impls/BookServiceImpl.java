package com.spring.services.impls;


import com.spring.constants.AppConstants;
import com.spring.entities.AgeRestriction;
import com.spring.entities.Author;
import com.spring.entities.Book;
import com.spring.entities.EditionType;
import com.spring.repositories.AuthorRepository;
import com.spring.repositories.BookRepository;
import com.spring.services.BookService;
import com.spring.util.FileUtil;
import com.spring.util.FileUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private FileUtil fileUtil;

    public BookServiceImpl() {
        this.fileUtil = new FileUtilImpl();
    }

    @Override
    public void seedBooks() {
        String[] bookData = fileUtil.readFile(AppConstants.BOOKS_FILE_PATH);

        for (String data : bookData) {
            String[] elements = data.split("\\s+");

            bookRepository.saveAndFlush(getBookByElements(elements));

        }

    }

    private Book getBookByElements(String[] elements) {

        Author author = getRandomAuthor();

        EditionType editionType = EditionType
                .values()[Integer.parseInt(elements[0])];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate date = LocalDate.parse(elements[1], formatter);

        int copies = Integer.parseInt(elements[2]);

        BigDecimal price = new BigDecimal(elements[3]);

        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(elements[4])];

        String title = getTitleFromData(elements);

        return new Book(ageRestriction, copies, editionType, price, date, title, author);
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        long authorIndex = random.nextInt((int) authorRepository.count()) + 1;

        return authorRepository.findById(authorIndex);
    }

    private String getTitleFromData(String[] data) {
        StringBuilder title = new StringBuilder();
        for (int i = 5; i < data.length; i++) {
            title.append(data[i]).append(" ");
        }
        return title.toString().trim();
    }
}
