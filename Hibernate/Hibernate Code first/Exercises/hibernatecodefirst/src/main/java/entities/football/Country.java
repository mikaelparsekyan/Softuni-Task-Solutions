package entities.football;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    private String name;

    private Set<Continent> continents;
    private Set<Town> towns;

    public Country() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity = Continent.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "countries_continents",
            joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"))
    public Set<Continent> getContinents() {
        return continents;
    }

    public void setContinents(Set<Continent> continents) {
        this.continents = continents;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
