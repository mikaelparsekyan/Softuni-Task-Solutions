import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>, Integer> sum = e -> {
            int result = 0;
            for (Integer element : e) {
                result += element;
            }
            return result;
        };
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum.apply(numbers));

    }
}
