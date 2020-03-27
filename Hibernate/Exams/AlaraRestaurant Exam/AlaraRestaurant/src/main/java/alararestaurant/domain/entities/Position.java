package alararestaurant.domain.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "positions")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Position extends BaseEntity {

    @NonNull
    @NotNull
    @Size(min = 3, max = 30)
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees;
}
