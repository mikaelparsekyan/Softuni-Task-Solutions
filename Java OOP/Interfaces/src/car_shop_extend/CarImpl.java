package car_shop_extend;

import car_shop_extend.interfaces.Car;

public class CarImpl implements Car {
    private String model;
    private String color;
    private Integer horsepower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsepower, String countryProduced) {
        this.model = model;
        this.horsepower = horsepower;
        this.color = color;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsepower;
    }

    @Override
    public String countryProduce() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format(
                "This is %s produced in %s and have %d tires",
                this.getModel(), this.countryProduce(), TIRES);
    }
}
