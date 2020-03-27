package alararestaurant.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "items")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Item extends BaseEntity {
    @NonNull
    @NotNull
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 symbols!")
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @NonNull
    @NotNull
    @DecimalMin("0.01")
    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;
}
