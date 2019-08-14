import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = elements[0];
        int s = elements[1];
        int x = elements[2];
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(stack::push);

        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.size() > 0) {
            if (stack.contains(x)) {
                System.out.println(true);
            } else {
                int min = findMin(stack);
                System.out.println(min);
            }
        } else {
            System.out.println(0);
        }
    }

    private static int findMin(ArrayDeque<Integer> stack) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stack.size(); i++) {
            int currentElement = stack.pop();
            if (currentElement < min) {
                min = currentElement;
            }
        }
        return min;
    }
}
