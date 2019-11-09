package vehicles.models;

public class Car extends Vehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    public void refuel(double addedFuel) {
        super.fuelQuantity += addedFuel;
    }

}
