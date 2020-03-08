package com.spring.services.impls;


import com.spring.constants.AppConstants;
import com.spring.constants.Exceptions;
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
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.spring.constants.AppConstants.*;
import static com.spring.constants.Exceptions.INVALID_DATE;

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
    public void getBookTitlesByAgeRestriction(Scanner scanner) {
        try {
            System.out.println("Enter age restriction: ");
            AgeRestriction ageRestriction = AgeRestriction
                    .valueOf(scanner.nextLine().toUpperCase());

            System.out.printf(AppConstants.ALL_BOOKS_BY_AGE_RESTRICTION,
                    ageRestriction.name());

            bookRepository.getBooksByAgeRestriction(ageRestriction)
                    .forEach(book -> System.out.println(book.getTitle()));

        } catch (IllegalArgumentException e) {
            System.err.println(Exceptions.INVALID_AGE_RESTRICTION);
        }
    }

    @Override
    public void getBookTitlesByEditionType(EditionType editionType, int copies) {
        System.out.printf(AppConstants.ALL_BOOKS_BY_EDITION_TYPE, editionType.name());

        bookRepository.getBooksByEditionTypeAndCopiesLessThan(editionType, copies)
                .forEach(book -> System.out.println(book.getTitle()));

    }

    @Override
    public void getBookTitlesAndPricesNotInBound(double lowBound, double topBound) {
        System.out.printf(AppConstants.ALL_BOOKS_NOT_IN_RANGE, lowBound, topBound);

        bookRepository
                .getBooksByPriceLessThanOrPriceGreaterThan(new BigDecimal(lowBound), new BigDecimal(topBound))
                .forEach(book -> System.out.printf(PRINT_BOOK_TITLE_AND_PRICE,
                        book.getTitle(), book.getPrice().floatValue()));
    }

    @Override
    public void getBookTitlesNotInYear(Scanner scanner) {
        try {
            System.out.printf(AppConstants.ALL_BOOKS_NOT_IN_YEAR,
                    Integer.parseInt(scanner.nextLine()));

//        bookRepository
//                .getBooksByReleaseDate_YearNot(year)
//                .forEach(book -> System.out.println(book.getTitle()));
        } catch (IllegalArgumentException e) {
            System.err.println();
        }
    }

    @Override
    public void getBooksByDateBefore(Scanner scanner) {
        try {
            System.out.println("Enter date: ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);

            System.out.printf(AppConstants.ALL_BOOK_RELEASED_BEFORE_DATE, date.toString());

            bookRepository
                    .getBooksByReleaseDateBefore(date)
                    .forEach(book ->
                            System.out.printf(PRINT_BOOK_TITLE_EDITION_TYPE_PRICE,
                                    book.getTitle(), book.getEditionType().name(), book.getPrice()));
        } catch (Exception e) {
            System.err.println(INVALID_DATE);
        }
    }

    @Override
    public void getBooksByContainingText(Scanner scanner) {

        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        List<Book> books = new LinkedList<>(bookRepository
                .getBooksByTitleContains(text));

        if (books.isEmpty()) {
            System.err.println("Nothing found!");
            return;
        }

        System.out.printf(AppConstants.ALL_TEXT_CONTAINING_TEXT, text);

        books.forEach(book -> System.out.println(book.getTitle()));
    }


    @Override
    public void getBooksCountByMinLength(Scanner scanner) {
        System.out.println("Enter min length for book title: ");
        try {
            int minLength = Integer.parseInt(scanner.nextLine());

            int bookCount = bookRepository
                    .countBooksByTitle(minLength);
            if (bookCount == 0) {
                System.err.printf("Nothing found with %d characters length!%n", minLength);
                return;
            }
            System.out.printf("There are %d books with longer title than %d symbols%n",
                    bookCount, minLength);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid length!");
            getBooksCountByMinLength(scanner);
        }
    }

    @Override
    public void getBooksCountByAuthorName() {

    }

    @Override
    public void getBookInfoByTitle(Scanner scanner) {
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();

        List<Object[]> bookInfo = bookRepository.getBooksInfo(bookTitle);

        if (bookInfo.isEmpty()) {
            System.err.println("Nothing found!");
            getBookInfoByTitle(scanner);
        }
        for (Object[] values : bookInfo) {
            System.out.printf("%s %s %s %.2f%n",
                    String.valueOf(values[0]),
                    String.valueOf(values[1]),
                    String.valueOf(values[2]),
                    Double.parseDouble(String.valueOf(values[3])));
        }
    }

    @Override
    public void increaseAllBooksByGivenDate(Scanner scanner) {

        try {
            System.out.println("Enter date: ");
            String dateStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
            LocalDate date = LocalDate.parse(dateStr, formatter);

            System.out.println("Enter number of copies: ");
            int copies = Integer.parseInt(scanner.nextLine());
            bookRepository
                    .getBooksByReleaseDateAfter(date)
                    .forEach(book -> {
                        book.setCopies(book.getCopies() + copies);
                        bookRepository.saveAndFlush(book);
                    });

        } catch (DateTimeParseException e) {
            System.err.println("Invalid date!");
            increaseAllBooksByGivenDate(scanner);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number of copies!");
            increaseAllBooksByGivenDate(scanner);
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
