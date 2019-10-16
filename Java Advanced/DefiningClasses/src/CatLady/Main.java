package CatLady;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Cat> cats = new LinkedList<>();
        while (!"End".equals(input)) {
            String[] elements = input.split("\\s+");
            cats.add(new Cat(elements[1], elements[0], Double.parseDouble(elements[2])));
            input = scanner.nextLine();
        }
        String catToPrint = scanner.nextLine();

        for (Cat currentCat : cats) {
            if (currentCat.getName().equals(catToPrint)) {
                System.out.println(currentCat.toString());
            }
        }
    }
}
