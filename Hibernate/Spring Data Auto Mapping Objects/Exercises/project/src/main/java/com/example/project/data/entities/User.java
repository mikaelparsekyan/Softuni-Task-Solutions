package com.example.project.data.entities;

import com.example.project.data.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends BaseEntity {

    @NonNull
    @NotNull
    @Pattern(message = "Email is not valid!", regexp = "")
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private String password;

    @NonNull
    @NotNull
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @OneToMany
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Set<Game> games;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

}
