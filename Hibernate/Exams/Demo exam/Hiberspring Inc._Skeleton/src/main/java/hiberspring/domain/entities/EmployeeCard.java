package hiberspring.domain.entities;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee_cards")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeCard extends BaseEntity {

    @Expose
    @Column(unique = true, nullable = false)
    @NotNull
    private String number;
}
