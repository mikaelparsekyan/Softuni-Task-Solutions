package border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> objects = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] elements = input.split("\\s+");
            if (elements.length == 2) {
                objects.add(new Robot(elements[0], elements[1]));
            } else if(elements.length==3){
                objects.add(new Citizen(elements[0], Integer.parseInt(elements[1]), elements[2]));
            }
            input = scanner.nextLine();
        }
        String endingIdDigits = scanner.nextLine();
        objects.stream()
                .filter(e -> e.getId()
                        .endsWith(endingIdDigits))
                .forEach(e->System.out.println(e.getId()));
    }
}
