package com.spring.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Book extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @NonNull
    @Column(name = "age_restriction", nullable = false)
    private AgeRestriction ageRestriction;

    @Column(nullable = false)
    @NonNull
    private int copies;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @NonNull
    @Column(name = "edition_type", nullable = false)
    private EditionType editionType;

    @Column(nullable = false)
    @NonNull
    private BigDecimal price;

    @Column(name = "release_date")
    @NonNull
    private LocalDate releaseDate;

    @Column(name = "title", nullable = false, length = 50)
    @NonNull
    private String title;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> categories = new HashSet<>();
}
