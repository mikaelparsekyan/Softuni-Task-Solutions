package wild_farm.models;

import wild_farm.abstracts.Mammal;

public class Mouse extends Mammal {
    public Mouse(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

}
