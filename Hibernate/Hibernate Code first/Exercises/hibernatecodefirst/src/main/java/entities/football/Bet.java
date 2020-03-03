package entities.football;

import entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {
    private BigDecimal betMoney;
    private LocalDate dateTime;
    private User user;

    public Bet() {
    }

    @Column(name = "bet_money")
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_time")
    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
