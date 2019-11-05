package pizza_calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaElements = readLine(scanner);
        String[] doughElements = readLine(scanner);
        try {
            Pizza pizza = new Pizza(pizzaElements[1],
                    Integer.parseInt(pizzaElements[2]));

            Dough dough = new Dough(doughElements[1], doughElements[2],
                    Double.parseDouble(doughElements[3]));

            pizza.setDough(dough);

            String line = scanner.nextLine();
            while (!"END".equals(line)) {
                String[] toppingElements = line.split("\\s+");

                Topping topping = new Topping(toppingElements[1],
                        Double.parseDouble(toppingElements[2]));

                pizza.addTopping(topping);

                line = scanner.nextLine();
            }
            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String[] readLine(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
