package spaceStation.models.planets;

import spaceStation.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetImpl implements Planet {
    private String name;
    private List<String> items;

    private static final String NAME_EXCEPTION = "Invalid name!";

    public PlanetImpl(String name) {
        this.setName(name);
        this.items = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name, NAME_EXCEPTION);
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
