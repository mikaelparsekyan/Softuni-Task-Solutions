import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[],Integer> findMinNumber = (a) ->{
            Integer minNumber = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                if(a[i]<minNumber){
                    minNumber = a[i];
                }
            }
            return minNumber;
        };
        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(findMinNumber.apply(numbers));

    }
}
