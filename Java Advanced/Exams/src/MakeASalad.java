import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> vegetables = new ArrayDeque<>();
        ArrayDeque<Integer> calories = new ArrayDeque<>();
        List<String> salads = new LinkedList<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .forEach(vegetables::offer);

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(calories::push);

        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            int caloriesVal = calories.peek();

            while (caloriesVal > 0 && !vegetables.isEmpty()) {
                String vegetable = vegetables.poll();
                caloriesVal -= getCalories(vegetable);
            }
            salads.add(calories.pop().toString());
        }
        for (String salad : salads) {
            System.out.print(salad + " ");
        }
        System.out.println();
        if(!calories.isEmpty()) {
            for (Integer calory : calories) {
                System.out.print(calory + " ");
            }
        } else {
            for (String vegetable : vegetables) {
                System.out.print(vegetable + " ");
            }

        }


    }

    private static int getCalories(String product) {
        int val = 0;
        switch (product) {
            case "tomato":
                val = 80;
                break;
            case "carrot":
                val = 136;
                break;
            case "lettuce":
                val = 109;
                break;
            case "potato":
                val = 215;
                break;
        }
        return val;
    }
}
