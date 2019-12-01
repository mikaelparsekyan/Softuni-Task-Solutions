package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(new LinkedList<>(models.values()));
    }

    @Override
    public void add(Gun model) {
        if (!this.models.containsKey(model.getName())) {
            this.models.put(model.getName(), model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model.getName(), model);
    }

    @Override
    public Gun find(String name) {
        return models.get(name);
    }
}
