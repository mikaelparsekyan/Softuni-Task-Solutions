import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] names = scanner.nextLine().split(" ");
        Arrays.stream(names).forEach(queue::offer);
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());

            }
            if (!isPrime(counter)) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Prime " + queue.peek());
            }
            counter++;
        }
        System.out.println("Last is " + queue.peek());
    }

    private static boolean isPrime(int counter) {
        boolean result = true;
        if (counter == 0 || counter == 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(counter); i++) {
                if (counter % i == 0) {
                    result = false;
                }
            }
            return result;
        }
    }
}
