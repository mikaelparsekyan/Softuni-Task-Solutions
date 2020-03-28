package hiberspring.domain.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product extends BaseEntity {

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private int clients;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Branch branch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return clients == product.clients &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, clients);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }
}

