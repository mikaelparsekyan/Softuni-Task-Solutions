package com.spring.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@NamedStoredProcedureQuery(name = "get_amount_of_books_by_name",
        procedureName = "get_amount_of_books_by_name",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,
                        name = "first_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,
                        name = "last_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT,
                        name = "count", type = Integer.class)
        })
public class Author extends BaseEntity {

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books;

    @Override
    public String toString() {
        return "Author{}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName);
    }
}
