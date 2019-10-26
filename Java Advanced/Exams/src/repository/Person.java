package repository;

public class Person {
    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +
                "\nAge: " + this.age +
                "\nBirthday: " + this.birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
