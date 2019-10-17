package Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Person> people = new LinkedHashMap<>();
        while (!"End".equals(input)) {
            String[] elements = input.split("\\s+");
            String personName = elements[0];
            String val2 = elements[1];
            String val3 = elements[2];
            String val4 = elements[3];
            Person person;
            if(!people.containsKey(personName)){
                person = new Person(personName);
                people.put(personName, person);
            } else{
                person = people.get(personName);
            }
            switch (val2) {
                case "company":
                    String val5 = elements[4];
                    Company company = new Company(val3,
                            val4, Double.parseDouble(val5));
                    person.setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(val3, val4);
                    person.getCollection().add(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(val3, val4);
                    person.getParents().add(parent);
                    break;
                case "children":
                    Child child = new Child(val3, val4);
                    person.getChildren().add(child);
                    break;
                case "car":
                    Car car = new Car(val3, val4);
                    person.setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }
        String personWanted = scanner.nextLine();
        Person person = people.get(personWanted);
        System.out.println(person);

    }
}
