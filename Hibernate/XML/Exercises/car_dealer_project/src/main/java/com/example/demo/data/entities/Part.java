package com.example.demo.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "parts")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Part extends BaseEntity {

    @XmlAttribute
    @NonNull
    @NotNull
    @Column
    private String name;

    @XmlAttribute
    @NonNull
    @NotNull
    @Column
    private BigDecimal price;

    @XmlAttribute
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
