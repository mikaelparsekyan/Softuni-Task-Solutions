package com.example.demo.data.entiites;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity {
    @XmlAttribute
    @Column
    private int age;

    @XmlAttribute(name = "first-name")
    @Column(name = "first_name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    @NotNull
    @NonNull
    @Size(min = 3)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @XmlTransient
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return "";
    }

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
