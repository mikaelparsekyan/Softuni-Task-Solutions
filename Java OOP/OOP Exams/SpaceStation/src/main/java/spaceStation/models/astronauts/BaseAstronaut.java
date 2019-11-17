package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.validator.Validator;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    private static final String NAME_EXCEPTION = "Astronaut name cannot be null or empty.";
    private static final String OXYGEN_EXCEPTION = "Cannot create Astronaut with negative oxygen!";

    BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        Validator.validateName(name, NAME_EXCEPTION);
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        Validator.validateOxygen(oxygen, OXYGEN_EXCEPTION);
        this.oxygen = oxygen;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - 10);
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

}
