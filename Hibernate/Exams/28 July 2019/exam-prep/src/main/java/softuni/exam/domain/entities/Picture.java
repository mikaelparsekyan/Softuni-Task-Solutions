package softuni.exam.domain.entities;

import com.google.gson.annotations.Expose;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "pictures")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Picture extends BaseEntity {
    @Expose
    @NotNull
    @NonNull
    @Column(nullable = false)
    private String url;

    @OneToMany(mappedBy = "picture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Team> teams;

    @OneToMany(mappedBy = "picture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Player> players;
}
