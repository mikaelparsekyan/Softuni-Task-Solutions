import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> filterNumber = e -> e % n != 0;
        Consumer<Integer> printNumbers = e -> System.out.print(e + " ");
        Collections.reverse(numbers);
        numbers.stream()
                .filter(filterNumber)
                .forEach(printNumbers);
    }
}
