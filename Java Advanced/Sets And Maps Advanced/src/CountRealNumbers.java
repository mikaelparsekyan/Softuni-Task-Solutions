import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        for (double value : input) {
            if (numbers.containsKey(value)) {
                numbers.put(value, numbers.get(value) + 1);
            } else {
                numbers.put(value, 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
