package restaurant;

public class Beverage extends Product {
    private double milliliters;

    public Beverage(String name, double price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }
}
