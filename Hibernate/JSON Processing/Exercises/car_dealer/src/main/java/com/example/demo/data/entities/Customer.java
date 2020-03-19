package com.example.demo.data.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
    private LocalDate birthDate;

    @NonNull
    @NotNull
    @Column(name = "is_young_driver", nullable = false)
    private boolean isYoungDriver;

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Sale sale;
}
