package alararestaurant.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "employees")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity {

    @NotNull
    @NonNull
    @Size(min = 3, max = 30)
    @Column(nullable = false)
    private String name;

    @NotNull
    @NonNull
    @Min(value = 15, message = "The age must not be lower than 15!")
    @Max(value = 80, message = "The age must not be higher than 80!")
    @Column(nullable = false)
    private int age;

    @NotNull
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;
}
