package wild_farm.models.felimes;

import wild_farm.models.Felime;

public class Tiger extends Felime {

    public Tiger(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

}
