package pizza_calories;

enum DoughModifiers {
    White(1.5),
    Wholegrain(1.0),
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private double cal;

    DoughModifiers(double cal) {
        this.cal = cal;
    }

    public double getCal() {
        return cal;
    }
}
