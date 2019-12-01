package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private List<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return this.astronauts;
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        for (Astronaut astronaut : this.astronauts) {
            if(astronaut.getName().equals(name)){
                return astronaut;
            }
        }
        return null;
    }
}
