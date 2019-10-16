package CatLady;

class Cat {
    private String name;
    private String breed;
    private double value;

    Cat(String name, String breed, double value) {
        this.name = name;
        this.breed = breed;
        this.value = value;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n",
                this.breed, this.name, this.value);
    }
}
