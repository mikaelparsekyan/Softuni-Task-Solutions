package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import static motocrossWorldChampionship.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Rider> riders;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        riders = new LinkedList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return riders;
    }

    @Override
    public void addRider(Rider rider) {
        if (rider == null) {
            throw new NullPointerException(RIDER_INVALID);
        }
        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(RIDER_NOT_PARTICIPATE, rider.getName()));
        }
        if (riders.contains(rider)) {
            throw new IllegalArgumentException(String.format(RIDER_EXISTS, rider.getName()));
        }
        riders.add(rider);
    }
}
