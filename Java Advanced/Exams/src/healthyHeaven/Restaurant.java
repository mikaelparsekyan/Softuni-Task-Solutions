package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        for (Salad salad : this.data) {
            if (salad.getName().equals(name)) {
                this.data.remove(salad);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        int minCal = Integer.MAX_VALUE;
        Salad healthiestSalad = null;
        for (Salad salad : this.data) {
            if (salad.getTotalCalories() < minCal) {
                minCal = salad.getTotalCalories();
                healthiestSalad = salad;
            }
        }
        return healthiestSalad;
    }

    public String generateMenu() {
        StringBuilder saladsString = new StringBuilder();
        List<Salad> saladList = this.data;
        for (int i = 0; i < saladList.size(); i++) {
            Salad salad = saladList.get(i);
            saladsString.append(salad.toString());
            if (i != saladList.size() - 1) {
                saladsString.append(System.lineSeparator());
            }
        }
        return String.format("%s have %d salads:%n" + saladsString,
                this.name, this.data.size());
    }
}
