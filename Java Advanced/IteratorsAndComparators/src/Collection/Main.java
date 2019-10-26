package Collection;

import Collection.ListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListIterator listIterator = new ListIterator(
                Arrays.stream(scanner.nextLine().split("\\s+")).skip(1)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.print());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listIterator.printAll();
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;

            }


            input = scanner.nextLine();
        }
    }
}
