import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nameLength = Integer.parseInt(scanner.nextLine());
        Predicate<String> filterLength = e-> e.length() <= nameLength;
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .filter(filterLength)
                .forEach(System.out::println);


    }
}
