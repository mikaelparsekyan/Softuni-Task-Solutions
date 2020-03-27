package alararestaurant.domain.entities;

import alararestaurant.domain.entities.enums.OrderType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Order extends BaseEntity {
    @NotNull
    @NonNull
    @Column(length = 512, nullable = false)
    private String customer;

    @NotNull
    @NonNull
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @NotNull
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false,
            columnDefinition = "VARCHAR(255) DEFAULT 'ForHere'")
    private OrderType orderType;

    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;
}
