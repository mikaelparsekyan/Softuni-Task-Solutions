package entities.hospital;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gps")
public class Gp extends BaseEntity {
    private Set<Patient> patients;

    public Gp() {
    }

    @OneToMany(mappedBy = "gp", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
