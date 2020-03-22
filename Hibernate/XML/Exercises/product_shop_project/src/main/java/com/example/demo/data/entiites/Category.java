package com.example.demo.data.entiites;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;


@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "categories")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Category extends BaseEntity {

    @XmlElement
    @NonNull
    @NotNull
    @Size(min = 3, max = 15)
    @Column
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();
}
