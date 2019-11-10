package animals.models;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%n" +
                "MEEOW", this.getName(), this.getFavouriteFood());
    }
}
