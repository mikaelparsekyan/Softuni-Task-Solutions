import java.util.*;
import java.util.stream.Collectors;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("Aluminium", 0);
        materials.put("Carbon fiber", 0);
        materials.put("Glass", 0);
        materials.put("Lithium", 0);


        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));//FIFO
        ArrayDeque<Integer> items = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));//LIFO

        while ((!items.isEmpty()) && (!liquids.isEmpty())) {
            int liquidElement = liquids.poll();
            int itemElement = items.pollLast();

            int sum = liquidElement + itemElement;
            if (sum == 25) {
                materials.put("Glass",
                        materials.get("Glass") + 1);
            } else if (sum == 50) {
                materials.put("Aluminium",
                        materials.get("Aluminium") + 1);
            } else if (sum == 75) {
                materials.put("Lithium",
                        materials.get("Lithium") + 1);
            } else if (sum == 100) {
                materials.put("Carbon fiber",
                        materials.get("Carbon fiber") + 1);
            } else {
                items.offer(itemElement + 3);///return item
            }
        }
        print(materials, liquids, items);
    }

    private static void print(Map<String, Integer> materials, ArrayDeque<Integer> liquids, ArrayDeque<Integer> items) {
        if (isSuccess(materials)) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        if (liquids.size() == 0) {
            System.out.println("Liquids left: none");
        } else {
            StringBuilder result = new StringBuilder();
            while (!liquids.isEmpty()){
                int val = liquids.pollFirst();
                result.append(val);
                if(liquids.size()>=1) {
                    result.append(", ");
                }
            }
            System.out.println("Liquids left: " + result.toString());
        }
        if (items.size() == 0) {
            System.out.println("Physical items left: none");
        } else {
            StringBuilder result = new StringBuilder();
            while (!items.isEmpty()){
                int val = items.pollLast();
                result.append(val);
                if(items.size()>=1) {
                    result.append(", ");
                }
            }
            System.out.println("Physical items left: " + result.toString());
        }
        materials.entrySet().stream().forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
    }

    private static boolean isSuccess(Map<String, Integer> materials) {
        for (var entry : materials.entrySet()) {
            int val = entry.getValue();
            if (val < 1) {
                return false;
            }
        }
        return true;
    }
}
