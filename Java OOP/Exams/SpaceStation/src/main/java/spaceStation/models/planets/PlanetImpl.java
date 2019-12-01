package spaceStation.models.planets;

import spaceStation.common.ExceptionMessages;
import spaceStation.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PlanetImpl implements Planet {
    private String name;
    private List<String> items;

    public PlanetImpl(String name) {
        this.setName(name);
        this.items = new LinkedList<>();
    }

    private void setName(String name) {
        Validator.validateName(name, ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
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
