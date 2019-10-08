import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Dragon>> dragonMap = new LinkedHashMap<>();
        //Map<String,Map<String, List<Integer>>> averageStats = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String dragonType = input[0];
            String dragonName = input[1];
            String damageAsString = input[2];
            String healthAsString = input[3];
            String armorAsString = input[4];
            int damage = 0;
            int health = 0;
            int armor = 0;
            if (!damageAsString.equals("null")) {
                damage = Integer.parseInt(damageAsString);
            } else {
                damage = 45;
            }
            if (!healthAsString.equals("null")) {
                health = Integer.parseInt(healthAsString);
            } else {
                health = 250;
            }
            if (!armorAsString.equals("null")) {
                armor = Integer.parseInt(armorAsString);
            } else {
                armor = 10;
            }

            addToValue(dragonMap, dragonType, dragonName, damage, health, armor);
        }
        dragonMap.entrySet().stream().forEach(e -> {
            double[] values = new double[3];
            getAverageValue(e, values);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", e.getKey(),
                    values[0], values[1], values[2]);
            e.getValue().entrySet().stream().sorted((a, b) -> {
                return a.getKey().compareTo(b.getKey());
            }).forEach(val -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        val.getKey(), val.getValue().getDamage(),
                        val.getValue().getHealth(),
                        val.getValue().getArmor());
            });
        });
    }

    private static void getAverageValue(Map.Entry<String, Map<String, Dragon>> e, double[] values) {
        for (Dragon value : e.getValue().values()) {
            values[0] += value.getDamage();
            values[1]+= value.getHealth();
            values[2] += value.getArmor();
        }
        values[0] /= e.getValue().values().size();
        values[1] /= e.getValue().values().size();
        values[2] /= e.getValue().values().size();
    }

    private static void addToValue(Map<String, Map<String, Dragon>> dragonMap,
                                   String dragonType, String dragonName, int damage, int health, int armor) {
        Map<String, Dragon> value = new LinkedHashMap<>();
        Map<String, Dragon> stats = new LinkedHashMap<>();
        if (dragonMap.containsKey(dragonType)) {
            value = dragonMap.get(dragonType);
            value.put(dragonName, new Dragon(
                    dragonName, health, damage, armor
            ));
        } else {
            value.put(dragonName, new Dragon(
                    dragonName, health, damage, armor
            ));
        }
        dragonMap.put(dragonType, value);
    }
}

class Dragon {
    String name;
    int health;
    int damage;
    int armor;

    public Dragon(String name, int health, int damage, int armor) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }
}
