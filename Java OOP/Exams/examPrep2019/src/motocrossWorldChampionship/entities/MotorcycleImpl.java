package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;
import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_MODEL;

public abstract class MotorcycleImpl implements Motorcycle {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.cubicCentimeters = cubicCentimeters;
        this.setHorsePower(horsePower);
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        if (cubicCentimeters == 125.0) {
            if (!(50 <= horsePower && horsePower <= 69)) {
                throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
            }
        } else if(cubicCentimeters == 450.0){
            if (!(70 <= horsePower && horsePower <= 100)) {
                throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
            }
        }
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }
}
