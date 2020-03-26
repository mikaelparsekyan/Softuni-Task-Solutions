package softuni.exam.domain.entities;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teams")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Team extends BaseEntity {
    @Expose
    @NonNull
    @NotNull
    @Column(nullable = false)
    @Length(min = 3, max = 20, message = "Name must be between 3 and 20 characters!")
    private String name;

    @Expose
    @NonNull
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)
    private Picture picture;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Player> players;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(picture, team.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, picture);
    }
}
