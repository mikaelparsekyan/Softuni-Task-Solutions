package entities.football;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {
    private String name;
    private CompetitionType competitionType;
    private Set<Game> games;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "competition_type_id", referencedColumnName = "id")
    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    @OneToMany(mappedBy = "competition",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}

