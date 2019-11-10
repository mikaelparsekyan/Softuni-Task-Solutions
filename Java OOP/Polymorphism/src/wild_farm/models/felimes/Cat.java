package wild_farm.models.felimes;

import wild_farm.models.Felime;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String type, String name, Double weight, String livingRegion, String breed) {
        super(type, name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat weightFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getType(),
                super.getName(),
                this.breed,
                weightFormat.format(super.getWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
