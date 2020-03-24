package com.example.demo.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "cars")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Car extends BaseEntity {

    @XmlElement
    @NotNull
    @NonNull
    @Column(nullable = false)
    private String make;

    @XmlElement
    @NotNull
    @NonNull
    @Column(nullable = false)
    private String model;

    @XmlElement(name = "travelled-distance")
    @NotNull
    @NonNull
    @Column(name = "travelled_distance", nullable = false)
    @Min(0)
    private long travelledDistance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    private Set<Part> parts = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return travelledDistance == car.travelledDistance &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, travelledDistance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", travelledDistance=" + travelledDistance +
                '}';
    }
}
