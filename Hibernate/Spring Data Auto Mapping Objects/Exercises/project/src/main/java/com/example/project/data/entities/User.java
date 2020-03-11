package com.example.project.data.entities;

import com.example.project.data.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "users_games",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    private Set<Game> games;


    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

}
