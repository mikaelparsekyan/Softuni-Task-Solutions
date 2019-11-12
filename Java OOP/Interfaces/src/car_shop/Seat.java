package car_shop;

public class Seat implements Car {
    private String model;
    private String color;
    private Integer horsepower;
    private String country;

    public Seat(String model, String color, Integer horsepower, String country) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.country = country;
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
        return this.country;
    }

    @Override
    public String toString() {
        return String.format(
                "This is %s produced in %s and have %d tires",
                this.getModel(), this.countryProduce(), TIRES);
    }
}
