
package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] values = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(input);

        for (int i = 0; i < values.length; i += 2) {
            String name = values[i];
            long quantity = Long.parseLong(values[i + 1]);

            if (name.length() == 3) {
                bag.addCash(name, quantity);
            } else if (name.toLowerCase().endsWith("gem")) {
                bag.addGem(name, quantity);
            } else if (name.toLowerCase().equals("gold")) {
                bag.addGold(quantity);
            }

        }
        System.out.println(bag);
    }
}