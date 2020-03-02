package entities.football;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "competition_type")
public class CompetitionType extends BaseEntity {
    private String type;

    public CompetitionType() {
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
