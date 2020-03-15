package com.example.project.data.entities;

import com.example.project.data.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends BaseEntity {

    @NonNull
    @NotNull
    @Size(min = 6, message = "Email size must be greater than 6 symbols!")
    @Pattern(regexp = ".+@.+\\..*", message = "Email is not valid!")
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @NotNull
    @Size(min = 6, message = "Password should be at least 6 symbols!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$",
            message = "Password should contains one upper, " +
                    "one lower and one digit symbol!")
    @Column(nullable = false)
    private String password;

    @NonNull
    @NotNull
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_games",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    private Set<Game> games = new HashSet<>();


    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Transient
    private List<Game> shoppingCart = new LinkedList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(fullName, user.fullName) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, fullName, role);
    }
}
