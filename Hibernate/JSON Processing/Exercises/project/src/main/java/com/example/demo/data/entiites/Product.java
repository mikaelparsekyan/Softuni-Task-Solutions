package com.example.demo.data.entiites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
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
    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private User seller;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(buyer, product.buyer) &&
                Objects.equals(seller, product.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price, buyer, seller);
    }

}
