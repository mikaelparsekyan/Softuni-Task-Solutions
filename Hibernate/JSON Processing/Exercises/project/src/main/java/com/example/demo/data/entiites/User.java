package com.example.demo.data.entiites;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity {
    @Expose
    @Column
    private int age;

    @Expose
    @Column(name = "first_name")
    private String firstName;

    @Expose
    @NotNull
    @NonNull
    @Size(min = 3)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;
}
