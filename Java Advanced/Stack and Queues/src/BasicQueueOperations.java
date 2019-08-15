import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = elements[0];
        int s = elements[1];
        int x = elements[2];
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(queue::offer);

        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.size() > 0) {
            if (queue.contains(x)) {
                System.out.println(true);
            } else {
                System.out.println(Collections.min(queue));
            }
        } else {
            System.out.println(0);
        }
    }

    private static int findMin(ArrayDeque<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < queue.size(); i++) {
            int currentElement = queue.poll();
            if (currentElement < min) {
                min = currentElement;
            }
        }
        return min;
    }
}
