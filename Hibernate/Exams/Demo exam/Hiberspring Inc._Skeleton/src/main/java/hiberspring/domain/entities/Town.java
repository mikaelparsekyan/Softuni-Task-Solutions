package hiberspring.domain.entities;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "towns")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Town extends BaseEntity {
    @Expose
    @Column(nullable = false)
    @NotNull
    private String name;

    @Expose
    @Positive
    @Column(nullable = false)
    @NotNull
    private int population;
}
