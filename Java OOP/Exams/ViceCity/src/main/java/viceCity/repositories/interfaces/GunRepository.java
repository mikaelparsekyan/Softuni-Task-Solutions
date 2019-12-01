package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun>{
    private Collection<Gun> models;

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        for (Gun model : models) {
            if(model.getName().equals(name)){
                return model;
            }
        }
        return null;
    }
}
