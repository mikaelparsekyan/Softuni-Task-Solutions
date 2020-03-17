package com.example.demo.data.entiites;

import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Product extends BaseEntity {

    @Expose
    @NotNull
    @NonNull
    @Column(nullable = false)
    @Size(min = 3)
    private String name;

    @Expose
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private User seller;

}
