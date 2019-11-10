package wild_farm.models;

import wild_farm.abstracts.Mammal;

public class Zebra extends Mammal {
    public Zebra(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

}
