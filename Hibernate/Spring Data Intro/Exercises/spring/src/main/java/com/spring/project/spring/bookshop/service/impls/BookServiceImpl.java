package com.spring.project.spring.bookshop.service.impls;

import com.spring.project.spring.bookshop.constants.AppConstants;
import com.spring.project.spring.bookshop.entities.Author;
import com.spring.project.spring.bookshop.entities.Book;
import com.spring.project.spring.bookshop.entities.enums.AgeRestriction;
import com.spring.project.spring.bookshop.entities.enums.EditionType;
import com.spring.project.spring.bookshop.repositories.AuthorRepository;
import com.spring.project.spring.bookshop.repositories.BookRepository;
import com.spring.project.spring.bookshop.service.BookService;
import com.spring.project.spring.bookshop.util.FileUtil;
import com.spring.project.spring.bookshop.util.FileUtilImpl;
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

    @Override
    public void getAllBooksByAuthorName(String authorName) {
        List<Author> authors = authorRepository.findAll();
        Author author = null;

        for (Author a : authors) {
            String fullName = a.getFirstName() + " " + a.getLastName();
            if (fullName.equals(authorName)) {
                author = a;
                break;
            }
        }
        List<Book> books = author.getBooks()
                .stream()
                .sorted((a1, a2) -> {
                    int res = a2.getReleaseDate().compareTo(a1.getReleaseDate());
                    if (res == 0) {
                        res = a1.getTitle().compareTo(a2.getTitle());
                    }
                    return res;
                })
                .collect(Collectors.toList());

        printBooks(books);

    }

    private void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.printf("Title: %s Date: %s Copies: %d%n",
                    book.getTitle(), book.getReleaseDate().toString(), book.getCopies());
        }
    }

    @Override
    public void getBookAfterYear(int year) {
        List<Book> books = this.bookRepository.findAll();

        for (Book book : books) {
            if (book.getReleaseDate().isAfter(LocalDate.of(year, 1, 1))) {
                System.out.println(book.getTitle());
            }
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
