package spaceStation.models.astronauts;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.validator.Validator;


public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        Validator.validateName(name, ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        Validator.validateOxygen(oxygen, ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
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

    @Override
    public String toString() {
        String items = String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.bag.getItems());
        if(this.bag.getItems().isEmpty()){
            items = "none";
        }

        return String.format("Name: %s%n" +
                "Oxygen: %.0f%n" +
                "Bag items: %s", this.getName(), this.getOxygen(), items);
    }
}
