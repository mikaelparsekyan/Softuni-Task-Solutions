import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> animals = new HashMap<>();
        Map<String, Integer> areas = new LinkedHashMap<>();
        while (!"Last Info".equals(command)) {
            String[] elements = command.split(":");
            String commandType = elements[0];
            if (commandType.equals("Add")) {
                String name = elements[1];
                int dailyFoodLimit = Integer.parseInt(elements[2]);
                String region = elements[3];
                if (animals.containsKey(name)) {
                    int currentValue = animals.get(name);

                    animals.put(name, currentValue + dailyFoodLimit);
                } else {
                    animals.put(name, dailyFoodLimit);
                    if (areas.containsKey(region)) {
                        areas.put(region, areas.get(region) + 1);
                    } else {
                        areas.put(region, 1);
                    }
                }

            } else if (commandType.equals("Feed")) {
                String name = elements[1];
                int food = Integer.parseInt(elements[2]);
                String region = elements[3];

                if (animals.containsKey(name)) {
                    int currentDailyFood = animals.get(name);
                    if (food >= currentDailyFood) {
                        System.out.printf("%s was successfully fed\n", name);
                        animals.remove(name);

                        if(areas.containsKey(region)){
                            int val = areas.get(region) - 1;
                            if(val <=0){
                                areas.remove(region);
                            } else {
                                areas.put(region, val);
                            }
                        }

                    } else {
                        animals.put(name, currentDailyFood - food);
                    }
                }
            }

            command = scanner.nextLine();
        }
        System.out.println("Animals:");
        animals.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(a -> {
            System.out.printf("%s -> %dg\n", a.getKey(), a.getValue());
        });
        System.out.println("Areas with hungry animals:");
        areas.entrySet().stream().sorted((a, b) -> {
            return b.getValue().compareTo(a.getValue());
        }).forEach(a -> {
            System.out.printf("%s : %d\n", a.getKey(), a.getValue());
        });
    }
}
