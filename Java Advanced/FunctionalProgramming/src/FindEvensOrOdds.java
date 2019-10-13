import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> even = e -> e % 2 == 0;
        Predicate<Integer> odd = e -> e % 2 != 0;
        int[] startAndEnd = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String type = scanner.nextLine();
        for (int i = startAndEnd[0]; i <= startAndEnd[1]; i++) {
            if(type.equals("odd")){
                if(odd.test(i)){
                    System.out.print(i + " ");
                }
            } else {
                if(even.test(i)){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
