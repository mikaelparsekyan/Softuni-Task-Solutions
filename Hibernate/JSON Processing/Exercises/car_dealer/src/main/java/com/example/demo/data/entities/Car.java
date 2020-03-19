package com.example.demo.data.entities;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
public class Car extends BaseEntity {
    @Expose
    @NotNull
    @NonNull
    @Column(nullable = false)
    private String make;

    @Expose
    @NotNull
    @NonNull
    @Column(nullable = false)
    private String model;

    @Expose
    @NotNull
    @NonNull
    @Column(name = "travelled_distance", nullable = false)
    @Min(0)
    private long travelledDistance;
}
