package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetRepository implements Repository<Planet>{
    private Map<String,Planet> planets;

    public PlanetRepository() {
        this.planets = new HashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return this.planets.values();
    }

    @Override
    public void add(Planet model) {
        this.planets.put(model.getName(),model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model.getName(),model);
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.get(name);
    }
}
