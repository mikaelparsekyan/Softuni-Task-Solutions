package com.spring.project.spring.user_system.entities;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class County extends BaseEntity {

    @Column(nullable = false)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Town> towns;
}
