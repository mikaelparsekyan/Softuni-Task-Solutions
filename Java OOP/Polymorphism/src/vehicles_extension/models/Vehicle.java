package vehicles_extension.models;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    private int tankCapacity;
    protected boolean isEmpty = false;

    protected Vehicle(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.setTankCapacity(tankCapacity);
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    private void setTankCapacity(int tankCapacity) {
        if (tankCapacity > 0) {
            this.tankCapacity = tankCapacity;
        }
    }

    public void refuel(double addedFuel) {
        if (addedFuel <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (fuelQuantity + addedFuel > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        if (this.getClass().getSimpleName().equals("Truck")) {
            this.fuelQuantity += addedFuel * 0.95;
        } else {
            this.fuelQuantity += addedFuel;
        }
    }

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

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(),
                this.fuelQuantity);
    }

}
