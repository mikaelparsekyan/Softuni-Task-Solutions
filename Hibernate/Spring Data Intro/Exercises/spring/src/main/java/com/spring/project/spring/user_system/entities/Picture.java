package com.spring.project.spring.user_system.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pictures")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Picture extends BaseEntity {

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String caption;

    @NonNull
    @Column(nullable = false)
    private String path;

    @ManyToMany
    @JoinTable(name = "pictures_albums",
            joinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"))
    private Set<Album> albums;
}
