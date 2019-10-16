package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String value) {
        this.model = model;
        this.engine = engine;
        try {
            this.weight = Integer.parseInt(value);
            this.color = "n/a";
        } catch (Exception e) {
            this.color = value;
            this.weight = -1;
        }
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "%s:\n" +
                        "Power: %d\n" +
                        "Displacement: %s\n" +
                        "Efficiency: %s\n" +
                        "Weight: %s\n" +
                        "Color: %s\n", this.model, engine.getModel(),
                engine.getPower(), (engine.getDisplacement() == -1 ? "n/a" : engine.getDisplacement()), engine.getEfficiency(),
                (this.weight == -1 ? "n/a" : this.weight), this.color);
    }
}
