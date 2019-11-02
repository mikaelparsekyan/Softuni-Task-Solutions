package shopping_spree;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        addPeopleValues(people, input.readLine().split(";"));
        addProducts(products, input.readLine().split(";"));

        String line = input.readLine();
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String productName = tokens[1];

            Person person = people.get(name);
            Product product = products.get(productName);

            if (person != null && product != null) {
                try {
                    person.buyProduct(product);
                    System.out.printf("%s bought %s%n", person.getName(), product.getName());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            line = input.readLine();
        }
        for (Person person : people.values()) {
            System.out.println(person);
        }
    }

    private static void addPeopleValues(Map<String, Person> people, String[] input) {
        for (String peopleInfo : input) {
            String[] nameAndMoney = peopleInfo.split("=");
            String name = nameAndMoney[0];
            int money = Integer.parseInt(nameAndMoney[1]);
            try {
                people.put(name, new Person(name, money));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    private static void addProducts(Map<String, Product> products, String[] input) {
        for (String product : input) {
            String[] nameAndCost = product.split("=");
            String name = nameAndCost[0];
            int cost = Integer.parseInt(nameAndCost[1]);
            try {
                products.put(name, new Product(name, cost));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }
}
