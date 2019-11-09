package vehicles.models;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public abstract void refuel(double addedFuel);

    public void drive(double distance) {
        DecimalFormat outputFormat = new DecimalFormat("#.##");
        double totalDriveFuel = distance * this.fuelConsumption;
        if (fuelQuantity < totalDriveFuel) {
            System.out.printf("%s needs refueling" + System.lineSeparator(),
                    this.getClass().getSimpleName());
            return;
        }
        fuelQuantity -= totalDriveFuel;
        System.out.printf("%s travelled " + outputFormat.format(distance) + " km" + System.lineSeparator(),
                this.getClass().getSimpleName());
    }
}
