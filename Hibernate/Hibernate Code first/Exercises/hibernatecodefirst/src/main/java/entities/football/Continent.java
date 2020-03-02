package entities.football;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseEntity {
    private String name;

    private Set<Country> countries;

    public Continent() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "continents", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
