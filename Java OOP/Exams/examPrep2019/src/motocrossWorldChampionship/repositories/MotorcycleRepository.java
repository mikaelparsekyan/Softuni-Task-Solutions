package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MotorcycleRepository implements Repository<Motorcycle> {
    private Collection<Motorcycle> models;

    public MotorcycleRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        for (Motorcycle model : models) {
            if (model.getModel().equals(name)) {
                return model;
            }
        }

        return null;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Motorcycle model) {
        models.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return models.remove(model);
    }
}
