package aquarium.models.fish;

public class SaltwaterFish extends BaseFish {
    private int INITIAL_SIZE = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + 2);
    }
}
