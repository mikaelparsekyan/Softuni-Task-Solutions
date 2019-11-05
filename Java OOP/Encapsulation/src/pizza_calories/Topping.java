package pizza_calories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!isToppingValid(toppingType)) {
            throw new IllegalArgumentException(
                    String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private boolean isToppingValid(String type) {
        ToppingsModifiers[] modifiers = ToppingsModifiers.values();
        for (ToppingsModifiers modifier : modifiers) {
            if (modifier.name().equals(type)) {
                return true;
            }
        }
        return false;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight) * ToppingsModifiers.valueOf(toppingType).getCal();
    }
}
