package alararestaurant.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class OrderItem extends BaseEntity {
    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @NotNull
    @NonNull
    @Positive
    @Column(nullable = false)
    private int quantity;
}
