package com.spring.project.spring.user_system.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Town extends BaseEntity {
    @Column(nullable = false)
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @NonNull
    private County country;

    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;
}
