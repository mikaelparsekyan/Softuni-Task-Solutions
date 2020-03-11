package com.example.project.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Game extends BaseEntity {

    @NonNull
    @NotNull
    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String trailer;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private String image;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private BigDecimal price;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private double size;

    @Column
    private String description;

    @NonNull
    @NotNull
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "games", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;


    @ManyToMany(mappedBy = "games", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

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
