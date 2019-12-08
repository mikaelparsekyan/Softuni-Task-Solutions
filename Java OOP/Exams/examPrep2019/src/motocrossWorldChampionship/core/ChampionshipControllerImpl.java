package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static motocrossWorldChampionship.common.ExceptionMessages.*;
import static motocrossWorldChampionship.common.OutputMessages.*;

public class ChampionshipControllerImpl implements ChampionshipController {
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Rider> riderRepository;
    private Repository<Race> raceRepository;

    @SuppressWarnings("unchecked")
    public ChampionshipControllerImpl(Repository<Rider> riderRepository,
                                      Repository<Motorcycle> motorcycleRepository,
                                      Repository<Race> raceRepository) {
        this.motorcycleRepository = motorcycleRepository;
        this.riderRepository = riderRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {
        Rider rider = new RiderImpl(riderName);
        if (riderRepository.getByName(riderName) != null) {
            throw new IllegalArgumentException(String.format(RIDER_EXISTS, riderName));
        }
        riderRepository.add(rider);
        return String.format(RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        Motorcycle currentMotorcycle = null;
        switch (type) {
            case "Speed":
                type = "SpeedMotorcycle";
                currentMotorcycle = new SpeedMotorcycle(model, horsePower);
                break;
            case "Power":
                type = "PowerMotorcycle";
                currentMotorcycle = new PowerMotorcycle(model, horsePower);
                break;
        }
        if (this.motorcycleRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, model));
        }
        motorcycleRepository.add(currentMotorcycle);
        return String.format(MOTORCYCLE_CREATED, type, model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        Rider rider = riderRepository.getByName(riderName);
        Motorcycle motorcycle = motorcycleRepository.getByName(motorcycleModel);
        if (rider == null) {
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }
        if (motorcycle == null) {
            throw new NullPointerException(String.format(MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }
        rider.addMotorcycle(motorcycle);
        return String.format(MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        Race race = raceRepository.getByName(raceName);
        Rider rider = riderRepository.getByName(riderName);

        if (race == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (rider == null) {
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }
        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(RIDER_NOT_PARTICIPATE, riderName));
        }
        race.addRider(rider);
        return String.format(RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }
        int laps = race.getLaps();
        Collection<Rider> riders = race.getRiders();
        if (riders.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        List<Rider> firstRiders = riders.stream()
                .sorted(Comparator.comparingDouble(
                        r -> r.getMotorcycle().calculateRacePoints(laps)))
                .collect(Collectors.toList());

        Collections.reverse(firstRiders);

        String result = String.format(RIDER_FIRST_POSITION, firstRiders.get(0).getName(), raceName) +
                System.lineSeparator() +
                String.format(RIDER_SECOND_POSITION, firstRiders.get(1).getName(), raceName) +
                System.lineSeparator() +
                String.format(RIDER_THIRD_POSITION, firstRiders.get(2).getName(), raceName);
        return result;
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(new RaceImpl(name, laps));
        return String.format(RACE_CREATED, name);
    }
}
