package sort_by_name_and_age;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            people.add(new Person(input[0], input[1],
                    Integer.parseInt(input[2])));
        }
        Collections.sort(people);

        for (Person person : people) {
            System.out.println(person);
        }

    }
}
