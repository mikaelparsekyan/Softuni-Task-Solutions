package restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    private static double COFFEE_MILLILITERS = 50;
    private static BigDecimal COFFEE_PRICE = new BigDecimal(3.50);
    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE.doubleValue(), COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getMilliliters() {
        return COFFEE_MILLILITERS;
    }

    public BigDecimal getPrice() {
        return COFFEE_PRICE;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
