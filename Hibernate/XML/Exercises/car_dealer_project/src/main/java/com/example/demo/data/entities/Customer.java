package com.example.demo.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Customer extends BaseEntity {

    @NonNull
    @NotNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthDate;

    @NonNull
    @NotNull
    @Column(name = "is_young_driver", nullable = false)
    private boolean isYoungDriver;

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Sale sale;
}
