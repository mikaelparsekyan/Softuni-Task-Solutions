package birthday_celebrations;

import birthday_celebrations.interfaces.Birthable;
import birthday_celebrations.interfaces.Identifiable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> objects = new LinkedList<>();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] elements = input.split("\\s+");

            switch (elements[0]) {
                case "Citizen":
                    objects.add(new Citizen(elements[1], Integer.parseInt(elements[2]),
                            elements[3], elements[4]));
                    break;
                case "Pet":
                    objects.add(new Pet(elements[1], elements[2]));
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable object : objects) {

            String currentDate = object.getBirthDate();

            currentDate = currentDate.substring(currentDate.length() - 4);

            if (currentDate.equals(year)) {
                System.out.println(object.getBirthDate());
            }
        }

    }
}
