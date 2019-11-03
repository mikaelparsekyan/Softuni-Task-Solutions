package sort_by_name_and_age;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private String getFirstName() {
        return firstName;
    }

    private int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", this.firstName,
                this.lastName, this.age);
    }

    @Override
    public int compareTo(Person person) {
        int firstCompare = this.firstName.compareTo(person.getFirstName());
        if (firstCompare == 0) {
            return Integer.compare(this.age,person.getAge());
        }
        return firstCompare;
    }
}
