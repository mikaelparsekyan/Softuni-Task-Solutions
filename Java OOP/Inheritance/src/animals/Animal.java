package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;
    private static final String ERROR_MESSAGE = "Invalid input!";

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.age = age;

    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.name = name;

    }

    public void setGender(String gender) {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.gender = gender;

    }


    public String produceSound() {
        return "";
    }


    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(),
                this.name, this.age, this.gender, this.produceSound());
    }
}
