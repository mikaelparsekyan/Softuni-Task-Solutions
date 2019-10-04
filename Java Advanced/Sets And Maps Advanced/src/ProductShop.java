import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> shop = new TreeMap<>();

        while (!"Revision".equals(input)) {
            String[] elements = input.split(", ");
            String shopName = elements[0];
            String product = elements[1];
            double price = Double.parseDouble(elements[2]);
            LinkedHashMap<String, Double> productAndPrice = new LinkedHashMap<>();
            if (shop.containsKey(shopName)) {
                productAndPrice = shop.get(shopName);
                productAndPrice.put(product, price);
            } else {
                productAndPrice.put(product, price);
            }
            shop.put(shopName, productAndPrice);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shop.entrySet()) {
            System.out.printf("%s-> %n", entry.getKey());
            for (Map.Entry<String, Double> value : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", value.getKey(), value.getValue());
            }

        }

    }
}
