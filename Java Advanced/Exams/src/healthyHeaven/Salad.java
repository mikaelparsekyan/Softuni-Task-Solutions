package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int result = 0;
        for (Vegetable vegetable : this.products) {
            result += vegetable.getCalories();
        }
        return result;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder vegetablesString = new StringBuilder();
        List<Vegetable> vegetables = this.products;
        for (int i = 0; i < vegetables.size(); i++) {
            Vegetable product = vegetables.get(i);
            vegetablesString.append(product.toString());
            if (i != vegetables.size() - 1) {
                vegetablesString.append(System.lineSeparator());
            }
        }

        return String.format("* Salad %s is %d calories and have %d products:%n"
                        + vegetablesString.toString(),
                this.name, this.getTotalCalories(), this.getProductCount());
    }
}
