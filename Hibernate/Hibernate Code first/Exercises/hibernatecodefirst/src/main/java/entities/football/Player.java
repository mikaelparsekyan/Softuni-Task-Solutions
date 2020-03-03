package entities.football;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
    private String name;
    private String squadNumber;
    private Team team;
    private Position position;
    private boolean isInjured;

    private Set<PlayerStatics> playerStatics;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "squad_number")
    public String getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    @OneToMany(mappedBy = "player", targetEntity = PlayerStatics.class)
    public Set<PlayerStatics> getPlayerStatics() {
        return playerStatics;
    }

    public void setPlayerStatics(Set<PlayerStatics> playerStatics) {
        this.playerStatics = playerStatics;
    }
}
