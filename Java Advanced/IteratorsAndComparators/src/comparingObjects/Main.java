package comparingObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new LinkedList<>();
        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            personList.add(new Person(tokens[0],
                    Integer.parseInt(tokens[1]), tokens[2]));
            line = scanner.nextLine();
        }
        int personIndex = Integer.parseInt(scanner.nextLine());
        if (personIndex >= 0 && personIndex < personList.size()) {
            Person personToCompare = personList.get(personIndex);
            //personList.remove(personToCompare);
            if (personToCompare != null) {
                List<Person> equalPeople = personList.stream()
                        .filter(e -> e.compareTo(personToCompare) == 0)
                        .collect(Collectors.toList());
                System.out.print(equalPeople.size() + " ");
                System.out.print(personList.size() - equalPeople.size() + " ");
                System.out.print(personList.size());
            }
        } else {
            System.out.println("No matches");
        }
    }
}
