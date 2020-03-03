package entities.football;

import entities.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player_statics")
public class PlayerStatics implements Serializable {
    private Game game;
    private Player player;
    private int scoredGoals;
    private int playerAssists;
    private int playedMinutes;


    public PlayerStatics() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals")
    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists")
    public int getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minutes")
    public int getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(int playedMinutes) {
        this.playedMinutes = playedMinutes;
    }
}
