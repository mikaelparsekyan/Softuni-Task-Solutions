import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> findSmallestNumberIndex = a -> {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < a.size(); i++) {
                int currentValue = a.get(i);
                if (currentValue <= min) {
                    min = currentValue;
                    minIndex = i;
                }
            }
            return minIndex;
        };
        System.out.println(findSmallestNumberIndex.apply(numbers));
    }
}
