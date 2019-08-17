import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> numbers = new ArrayDeque<>();
        numbers.push((long) 1);
        numbers.push((long) 1);
        for (int i = 0; i < n - 1; i++) {
            numbers.push(sum(numbers));
        }
        System.out.println(numbers.peek());
    }

    static long sum(ArrayDeque<Long> numbers) {
        long firstNumber = numbers.pop();
        long secondNumber = numbers.pop();
        numbers.push(firstNumber);
        return firstNumber + secondNumber;
    }
}
