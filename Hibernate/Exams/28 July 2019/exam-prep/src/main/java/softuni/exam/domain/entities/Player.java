package softuni.exam.domain.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
    @Expose
    @NonNull
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Expose
    @NonNull
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Expose
    @NonNull
    @NotNull
    @Column(nullable = false)
    @Min(1)
    @Max(99)
    private int number;

    @Expose
    @NonNull
    @NotNull
    @Column(nullable = false)
    @Min(0)
    private BigDecimal salary;

    @Expose
    @NonNull
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Position position;

    @Expose
    @NonNull
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    @Expose
    @NonNull
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)
    private Picture picture;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Player name: %s %s%n" +
                        "   Number: %d%n" +
                        "   Salary: %.2f%n" +
                        "   Team: %s%n", getFirstName(), getLastName(), getNumber(),
                getSalary().doubleValue(), getTeam().getName()));
        return result.toString();
    }
}
