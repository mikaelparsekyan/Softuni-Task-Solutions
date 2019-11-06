package car_shop_extend;

import car_shop_extend.interfaces.Car;
import car_shop_extend.interfaces.Sellable;

public class Seat extends CarImpl implements Car, Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsepower, String country, Double price) {
        super(model, color, horsepower, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
