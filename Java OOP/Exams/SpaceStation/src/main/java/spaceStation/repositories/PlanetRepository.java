package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.*;

public class PlanetRepository implements Repository<Planet>{
    private List<Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return this.planets;
    }

    @Override
    public void add(Planet model) {
        this.planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        for (Planet planet : this.planets) {
            if(planet.getName().equals(name)){
                return planet;
            }
        }
        return null;
    }
}
