package com.example.demo.data.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales")
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
public class Sale extends BaseEntity {

    @NonNull
    @NotNull
    @Column
    private double discount;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
