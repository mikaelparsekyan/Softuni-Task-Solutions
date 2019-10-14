package CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.brand, this.model, this.horsepower);
    }
}
