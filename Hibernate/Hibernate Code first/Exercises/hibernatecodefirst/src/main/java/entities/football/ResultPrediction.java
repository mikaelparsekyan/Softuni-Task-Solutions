package entities.football;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "result_predicitions")
public class ResultPrediction extends BaseEntity {
    private String prediciton;

    public ResultPrediction() {
    }

    @Column
    public String getPrediciton() {
        return prediciton;
    }

    public void setPrediciton(String prediciton) {
        this.prediciton = prediciton;
    }
}
