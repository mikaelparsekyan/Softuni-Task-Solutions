package com.example.demo.data.entiites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age, firstName, lastName);
    }
}
