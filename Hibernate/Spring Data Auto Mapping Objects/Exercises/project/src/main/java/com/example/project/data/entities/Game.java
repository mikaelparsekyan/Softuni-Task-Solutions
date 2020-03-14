package com.example.project.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Game extends BaseEntity {

    @NonNull
    @NotNull
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "[A-Z].*", message = "Game title must starts with uppercase!")
    @Size(min = 3, max = 100)
    private String title;

    @NonNull
    @NotNull
    @Column(length = 11)
    private String trailer;

    @NonNull
    @NotNull
    @Column(nullable = false)
    @Pattern(regexp = "^https://.*|^http://.*", message = "Invalid image url!")
    private String image;

    @NonNull
    @NotNull
    @Column(nullable = false)
    @Min(0)
    private BigDecimal price;

    @NonNull
    @NotNull
    @Column(nullable = false)
    @Min(0)
    private double size;

    @NonNull
    @NotNull
    @Column
    @Size(min = 20)
    private String description;

    @NonNull
    @NotNull
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "games", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;


    @ManyToMany(mappedBy = "games", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Override
    public String toString() {
        return "Title: " + this.getTitle() + System.lineSeparator() +
                "Price: " + String.format("%.2f", getPrice().floatValue()) + System.lineSeparator() +
                "Description: " + this.getDescription() + System.lineSeparator() +
                "Release date: " + this.getReleaseDate()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return Double.compare(game.size, size) == 0 &&
                Objects.equals(title, game.title) &&
                Objects.equals(trailer, game.trailer) &&
                Objects.equals(image, game.image) &&
                Objects.equals(price, game.price) &&
                Objects.equals(description, game.description) &&
                Objects.equals(releaseDate, game.releaseDate) &&
                Objects.equals(users, game.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, trailer, image, price, size, description, releaseDate);
    }
}
