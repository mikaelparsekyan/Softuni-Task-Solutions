package pizza_calories;

enum ToppingsModifiers {
    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private double cal;

    ToppingsModifiers(double cal) {
        this.cal = cal;
    }

    public double getCal() {
        return cal;
    }
}
