package entities.football;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    private String name;
    private Country country;

    public Town() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
