package com.example.demo.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
public class Car extends BaseEntity {
    @NotNull
    @NotNull
    @Column(nullable = false)
    private String make;

    @NotNull
    @NotNull
    @Column(nullable = false)
    private String model;

    @NotNull
    @NotNull
    @Column(name = "travelled_distance", nullable = false)
    @Min(0)
    private double travelledDistance;
}
