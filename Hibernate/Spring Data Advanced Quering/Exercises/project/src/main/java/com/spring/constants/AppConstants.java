package com.spring.constants;

public class AppConstants {
    public static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";
    public static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";
    public static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.txt";

    public static final String ALL_BOOKS_BY_AGE_RESTRICTION =
            "ALL BOOKS BY AGE RESTRICTION: %S%n%n";

    public static final String ALL_BOOKS_BY_EDITION_TYPE =
            "ALL BOOKS BY EDITION TYPE: %S%n%n";

    public static final String PRINT_BOOK_TITLE_AND_PRICE =
            "%s - $%.2f %n";

    public static final String ALL_BOOKS_NOT_IN_RANGE =
            "ALL BOOKS NOT IN RANGE [%.2f - %.2f]%n%n";

    public static final String ALL_BOOKS_NOT_IN_YEAR =
            "ALL BOOKS NOT RELEASED AT %d%n%n";

    public static final String PRINT_BOOK_TITLE_EDITION_TYPE_PRICE =
            "%s %s %.2f%n";

    public static final String ALL_BOOK_RELEASED_BEFORE_DATE =
            "ALL BOOKS RELEASED BEFORE - [%s]%n%n";

    public static final String PRINT_AUTHOR_INFORMATION =
            "%s %s%n";

    public static final String ALL_TEXT_CONTAINING_TEXT = "ALL BOOKS WHICH CONTAINS [%s]%n%n";

}
