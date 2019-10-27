package strategyPattern;

import java.util.Comparator;

public class FirstPersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int firstCompare = Integer.compare(person1.getName().length(),
                person2.getName().length());
        if (firstCompare == 0) {
            return Character.compare(person1.getName().toLowerCase().charAt(0),
                    person2.getName().toLowerCase().charAt(0));


        } else {
            return firstCompare;
        }
    }
}
