package com.spring.project.spring.user_system.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "albums")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album extends BaseEntity {

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column(name = "background_color")
    private String backgroundColor;

    @ManyToMany(mappedBy = "albums", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Picture> pictures;

    @OneToOne(mappedBy = "album", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
}
