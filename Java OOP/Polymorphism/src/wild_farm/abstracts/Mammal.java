package wild_farm.abstracts;

import wild_farm.foods.Food;
import wild_farm.foods.Meat;
import wild_farm.foods.Vegetable;
import wild_farm.models.Mouse;
import wild_farm.models.Zebra;
import wild_farm.models.felimes.Tiger;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    protected String livingRegion;

    protected Mammal(String type, String name, Double weight, String livingRegion) {
        super(type,name,weight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            if (this instanceof Tiger) {
                throw new IllegalArgumentException(
                        "Tigers are not eating that type of food!");
            }
        } else if(food instanceof Meat){
            if (this instanceof Mouse) {
                throw new IllegalArgumentException(
                        "Mice are not eating that type of food!");

            } else if(this instanceof Zebra){
                throw new IllegalArgumentException(
                        "Zebras are not eating that type of food!");
            }
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat formatWeight = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                super.getType(),
                super.getName(),
                formatWeight.format(super.getWeight()),
                this.livingRegion,
                super.getFoodEaten());
    }
}
