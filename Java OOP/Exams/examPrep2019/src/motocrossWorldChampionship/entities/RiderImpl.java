package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_NAME;
import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_INVALID;

public class RiderImpl implements Rider {
    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    public RiderImpl(String name) {
        this.setName(name);
        canParticipate = false;//TODO
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null) {
            canParticipate = false;
            throw new NullPointerException(MOTORCYCLE_INVALID);
        }
        this.motorcycle = motorcycle;
        canParticipate = true;
    }

    @Override
    public void winRace() {
        numberOfWins = numberOfWins + 1;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }
}
