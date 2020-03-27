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
@Table(name = "categories")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Category extends BaseEntity {
    @NotNull
    @NonNull
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 symbols!")
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> items;
}
