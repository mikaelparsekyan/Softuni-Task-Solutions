package wild_farm.abstracts;

import wild_farm.foods.Food;

public abstract class Animal {
    protected String name;
    protected String type;
    protected Double weight;
    protected Integer foodEaten = 0;

    public Animal(String type, String name, Double weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
    }

    protected String getName() {
        return name;
    }

    protected String getType() {
        return type;
    }

    protected Double getWeight() {
        return weight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);
}
