package com.example.demo.data.entities;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parts")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Part extends BaseEntity {

    @Expose
    @NonNull
    @NotNull
    @Column
    private String name;

    @Expose
    @NonNull
    @NotNull
    @Column
    private BigDecimal price;

    @Expose
    @Column
    private int quantity;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @ManyToMany(mappedBy = "parts", targetEntity = Car.class, fetch = FetchType.EAGER)
    private Set<Car> cars = new HashSet<>();


}
