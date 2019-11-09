package vehicles.models;

public class Truck extends Vehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    public void refuel(double addedFuel) {
        super.fuelQuantity += addedFuel * 0.95;
    }
}
