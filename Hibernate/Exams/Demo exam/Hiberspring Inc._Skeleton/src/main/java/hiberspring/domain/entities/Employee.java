package hiberspring.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee extends BaseEntity {
    @Column(nullable = false)
    @NotNull
    private String firstName;

    @Column(nullable = false)
    @NotNull
    private String lastName;

    @Column(nullable = false)
    @NotNull
    private String position;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private EmployeeCard card;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Branch branch;
}
