package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanets;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        Astronaut astronaut = null;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
        }
        if (astronaut != null) {
            astronautRepository.add(astronaut);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronautToRetire = astronautRepository.findByName(astronautName);
        if (astronautToRetire == null) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronautToRetire);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitableAstronauts = new LinkedList<>();
        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            if (astronaut.getOxygen() > 60) {
                suitableAstronauts.add(astronaut);
            }
        }
        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        } else {
            Mission mission = new MissionImpl();
            Planet planetToExplore = this.planetRepository.findByName(planetName);
            
            int peopleBeforeExploration = suitableAstronauts.size();

            mission.explore(planetToExplore, suitableAstronauts);

            int deads = peopleBeforeExploration - suitableAstronauts.size();

            exploredPlanets++;
            return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deads);
        }
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets))
                .append(System.lineSeparator());
        report.append(ConstantMessages.REPORT_ASTRONAUT_INFO);
        for (Astronaut astronaut : astronautRepository.getModels()) {
            report.append(System.lineSeparator()).append(astronaut.toString());
        }
        return report.toString();
    }
}
