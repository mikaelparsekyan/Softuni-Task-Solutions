package CarSalesman;

class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    Engine(String model, int power, String value) {
        this.model = model;
        this.power = power;
        try {
            this.displacement = Integer.parseInt(value);
            this.efficiency = "n/a";
        } catch (Exception e) {
            this.displacement = -1;
            this.efficiency = value;
        }
    }

    Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    String getModel() {
        return model;
    }

    int getPower() {
        return power;
    }

    int getDisplacement() {
        return displacement;
    }

    String getEfficiency() {
        return efficiency;
    }
}
