package SpeedRacing;

public class Car {
    String model;
    double fuelAmount;
    double fuelPrice;
    int distance;

    public Car(String model, double fuelAmount, double fuelPrice) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPrice = fuelPrice;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
}
