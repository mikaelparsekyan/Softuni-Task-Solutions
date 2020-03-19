package com.example.demo.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "parts")
@NoArgsConstructor
@Data
public class Part extends BaseEntity {

    @NonNull
    @NotNull
    @Column
    private String name;

    @NonNull
    @NotNull
    @Column
    private BigDecimal price;

    @Column
    private int quantity;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @ManyToMany
    @JoinTable(name = "parts_cars",
            joinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
    private Set<Car> cars;


}
