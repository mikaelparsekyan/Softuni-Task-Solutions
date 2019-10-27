package comparingObjects;


public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;


    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }


    @Override
    public int compareTo(Person person) {
        int firstCompare = this.name.compareTo(person.getName());
        if (firstCompare == 0) {
            int secondCompare = Integer.compare(this.age, person.getAge());
            if (secondCompare == 0) {
                return this.town.compareTo(person.getTown());
            } else {
                return secondCompare;
            }
        } else {
            return firstCompare;
        }
    }
}
