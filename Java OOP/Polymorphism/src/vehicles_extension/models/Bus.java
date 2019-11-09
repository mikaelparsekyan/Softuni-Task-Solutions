package vehicles_extension.models;

public class Bus extends Vehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption,int tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
        if(!super.isEmpty){
            super.fuelConsumption += FUEL_CONSUMPTION_INCREASE;
        }
    }
}
