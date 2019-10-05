import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        int n = params[0] + params[1];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            if (i < params[0]) {
                firstSet.add(value);
            } else {
                secondSet.add(value);
            }
        }
        firstSet.retainAll(secondSet);
        for (Integer element : firstSet) {
            System.out.print(element + " ");
        }


    }
}
