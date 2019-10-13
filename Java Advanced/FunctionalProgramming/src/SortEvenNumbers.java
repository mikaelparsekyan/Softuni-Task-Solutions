import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> filterEvens = e -> e % 2 == 0;
        Consumer<List<Integer>> print = e -> {
            for (int i = 0; i < e.size(); i++) {
                System.out.print(e.get(i));
                if (e.size() - 1 > i) {
                    System.out.print(", ");
                }
            }
        };
        List<Integer> evenNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(filterEvens)
                .collect(Collectors.toList());

        print.accept(evenNumbers);
        Collections.sort(evenNumbers);
        System.out.println();
        print.accept(evenNumbers);

    }
}
