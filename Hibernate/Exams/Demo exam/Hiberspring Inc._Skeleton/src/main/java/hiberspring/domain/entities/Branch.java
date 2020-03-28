package hiberspring.domain.entities;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "branches")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Branch extends BaseEntity {
    @Expose
    @Column(nullable = false)
    @NotNull
    private String name;

    @OneToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Town town;

    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;
}
