package softuni.exam.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import softuni.exam.domain.enums.Position;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Player extends BaseEntity {
    @NonNull
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NonNull
    @NotNull
    @Column(nullable = false)
    @Min(1)
    @Max(99)
    private int number;

    @NonNull
    @NotNull
    @Column(nullable = false)
    @Min(0)
    private BigDecimal salary;

    @NonNull
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Position position;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)
    private Picture picture;
}
