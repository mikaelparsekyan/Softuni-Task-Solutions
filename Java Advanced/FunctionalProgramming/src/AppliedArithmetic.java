import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Consumer<int[]> addFunction = e -> {
            for (int i = 0; i < e.length; i++) {
                e[i]++;
            }
        };
        Consumer<int[]> subtractFunction = e -> {
            for (int i = 0; i < e.length; i++) {
                e[i]--;
            }
        };
        Consumer<int[]> multiplyFunction = e -> {
            for (int i = 0; i < e.length; i++) {
                e[i] *= 2;
            }
        };
        Consumer<int[]> printFunction = e -> {
            System.out.println();
            for (int value : e) {
                System.out.print(value + " ");
            }
        };
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    addFunction.accept(numbers);
                    break;
                case "multiply":
                    multiplyFunction.accept(numbers);
                    break;
                case "subtract":
                    subtractFunction.accept(numbers);
                    break;
                case "print":
                    printFunction.accept(numbers);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
