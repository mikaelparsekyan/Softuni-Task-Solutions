package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);

    }

    public void setName(String name) {
        if (name.isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double result;
        if (this.age > 11) {
            result = 0.75;
        } else if (this.age >= 6) {
            result = 1.00;
        } else {
            result = 2.00;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.getName(), this.getAge(), this.productPerDay());
    }
}
