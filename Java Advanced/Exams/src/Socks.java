import java.util.*;
import java.util.stream.Collectors;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pairs = new LinkedList<>();

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(leftSocks::push);

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(rightSocks::offer);

        while ((!rightSocks.isEmpty()) && (!leftSocks.isEmpty())) {
            int leftSock = leftSocks.peek();
            int rightSock = rightSocks.peek();
            if (leftSock > rightSock) {
                int pair = rightSock + leftSock;
                rightSocks.poll();
                leftSocks.pop();
                pairs.add(pair);
            } else if (rightSock > leftSock) {
                leftSocks.pop();
            } else {
                rightSocks.poll();
                leftSocks.pop();
                leftSocks.push(leftSock + 1);
            }
        }
        System.out.println(pairs.stream().max(Integer::compareTo).get().intValue());
        for (Integer pair : pairs) {
            System.out.print(pair + " ");
        }

    }
}
