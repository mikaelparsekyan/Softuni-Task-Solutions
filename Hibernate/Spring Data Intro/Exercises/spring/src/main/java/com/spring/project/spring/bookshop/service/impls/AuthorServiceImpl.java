package com.spring.project.spring.bookshop.service.impls;

import com.spring.project.spring.bookshop.constants.AppConstants;
import com.spring.project.spring.bookshop.entities.Author;
import com.spring.project.spring.bookshop.entities.Book;
import com.spring.project.spring.bookshop.repositories.AuthorRepository;
import com.spring.project.spring.bookshop.service.AuthorService;
import com.spring.project.spring.bookshop.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public void getAuthorWithMinNumberOfBooks(int bookNumber, int bookReleaseYear) {
        List<Author> authors = authorRepository.findAll();

        for (Author author : authors) {
            Set<Book> authorBooks = author.getBooks();

            if (isAuthorContainBookBefore(authorBooks, bookReleaseYear) && authorBooks.size() >= bookNumber) {
                System.out.println(author.getFirstName() + "    " + author.getLastName());
            }
        }

    }

    @Override
    public void getAllAuthorsOrderByNumberOfBooks() {
        List<Author> orderedAuthors = authorRepository
                .findAll()
                .stream()
                .sorted((a1, a2) ->
                        Integer.compare(a2.getBooks().size(),
                                a1.getBooks().size()))
                .collect(Collectors.toList());

        printOrderedAuthors(orderedAuthors);
    }

    private void printOrderedAuthors(List<Author> authors) {
        for (Author author : authors) {
            System.out.printf("%s %s    |   Count of books: %d%n",
                    author.getFirstName(), author.getLastName(),
                    author.getBooks().size());
        }

    }

    private boolean isAuthorContainBookBefore(Set<Book> books, int bookReleaseYear) {
        for (Book book : books) {
            if (book.getReleaseDate()
                    .isBefore(LocalDate.of(bookReleaseYear, 1, 1))) {
                return true;
            }
        }
        return false;
    }

    private Author getAuthorByData(String data) {
        String[] elements = data.split("\\s+");

        String firstName = elements[0];
        String lastName = elements[1];

        return new Author(firstName, lastName);
    }
}
