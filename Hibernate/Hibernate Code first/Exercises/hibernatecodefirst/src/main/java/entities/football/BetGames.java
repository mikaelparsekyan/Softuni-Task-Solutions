package entities.football;

import entities.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bet_games")
public class BetGames implements Serializable {

    private Game game;
    private Bet bet;
    private ResultPrediction resultPrediction;

    public BetGames() {
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
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @OneToOne
    @JoinColumn(name = "result_predicition", referencedColumnName = "id")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
