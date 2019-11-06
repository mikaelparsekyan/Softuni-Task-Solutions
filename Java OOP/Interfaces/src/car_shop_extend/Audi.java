package car_shop_extend;

import car_shop_extend.interfaces.Rentable;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsepower, String country,
                Integer minRentDay, Double pricePerDay) {
        super(model, color, horsepower, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return String.format(
                "This is %s produced in %s and have %d tires" + System.lineSeparator() +
                        "Minimum rental period of %d days. Price per day %f",
                this.getModel(), this.countryProduce(), TIRES,
                this.getMinRentDay(), this.getPricePerDay());
    }
}
