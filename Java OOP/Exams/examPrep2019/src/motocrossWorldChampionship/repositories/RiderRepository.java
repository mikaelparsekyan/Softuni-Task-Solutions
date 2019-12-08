package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> models;

    public RiderRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        for (Rider model : models) {
            if (model.getName().equals(name)) {
                return model;
            }
        }

        return null;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Rider model) {
        models.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return models.remove(model);
    }
}
