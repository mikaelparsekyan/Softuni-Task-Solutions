package softuni.exam.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "teams")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Team extends BaseEntity {
    @NonNull
    @NotNull
    @Column(nullable = false)
    @Length(min = 3, max = 20, message = "Name must be between 3 and 20 characters!")
    private String name;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)
    private Picture picture;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Player> players;

}
