package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire frontLeftTire;
    private Tire frontRightTire;
    private Tire backLeftTire;
    private Tire backRightTire;

    Car(String model, Engine engine, Cargo cargo, Tire frontLeftTire,
        Tire frontRightTire, Tire backLeftTire, Tire backRightTire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.frontLeftTire = frontLeftTire;
        this.frontRightTire = frontRightTire;
        this.backLeftTire = backLeftTire;
        this.backRightTire = backRightTire;
    }

    String getModel() {
        return model;
    }
    Engine getEngine() {
        return engine;
    }

    Cargo getCargo() {
        return cargo;
    }

    boolean isAllPressureValid() {
        return frontLeftTire.pressure < 1 ||
                frontRightTire.pressure < 1 ||
                backLeftTire.pressure < 1 ||
                backRightTire.pressure < 1;
    }
}
