package com.example.demo.data.entiites;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Category extends BaseEntity {

    @NonNull
    @NotNull
    @Size(min = 3, max = 15)
    @Column
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();
}
