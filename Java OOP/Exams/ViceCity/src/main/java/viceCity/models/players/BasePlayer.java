package viceCity.models.players;

import viceCity.common.ExceptionMessages;
import viceCity.core.validator.Validator;
import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }


    private void setName(String name) {
        Validator.validateName(name, ExceptionMessages.PLAYER_NULL_USERNAME);
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        Validator.validateNumber(lifePoints, ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        this.lifePoints = lifePoints;
    }


    @Override
    public void takeLifePoints(int points) {
        lifePoints -= points;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public boolean isAlive() {
        return lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }
}
