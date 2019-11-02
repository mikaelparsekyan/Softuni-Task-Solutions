package shopping_spree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "%s can't afford %s";

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    public void buyProduct(Product p) {
        if (this.money - p.getCost() >= 0) {
            this.money -= p.getCost();
            this.products.add(p);
        } else {
            throw new IllegalArgumentException(String.format(NOT_ENOUGH_MONEY_MESSAGE,
                    this.name, p.getName()));
        }
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name).append(" – ");
        if (this.products.isEmpty()) {
            result.append("Nothing bought");
        } else {
            for (int i = 0; i < this.products.size(); i++) {
                result.append(this.products.get(i).getName());
                if (i != this.products.size() - 1) {
                    result.append(", ");
                }
            }
        }
        return result.toString();
    }
}
