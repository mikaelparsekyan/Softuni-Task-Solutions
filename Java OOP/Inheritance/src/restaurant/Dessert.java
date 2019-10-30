package restaurant;

public class Dessert extends Food {
    private double calories;

    public Dessert(String name, double price,
                   double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
