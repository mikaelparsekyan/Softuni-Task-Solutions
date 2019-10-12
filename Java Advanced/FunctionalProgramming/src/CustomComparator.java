import java.util.*;
import java.util.function.Consumer;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> sort = array -> {
            int swapIndex = 0;
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                int minVal = Integer.MAX_VALUE;
                for (int j = i; j < array.length; j++) {
                    if (array[j] < minVal) {
                        minVal = array[j];
                        swapIndex = j;
                    }
                }
                int currentValue = array[index];
                array[index] = array[swapIndex];
                array[swapIndex] = currentValue;
                index++;
            }
        };
        Consumer<int[]> printEven = e -> {
            for (int i : e) {
                if(i%2==0){
                    System.out.print(i + " ");
                }
            }
        };
        Consumer<int[]> printOdd = e -> {
            for (int i : e) {
                if(i%2!=0){
                    System.out.print(i + " ");
                }
            }
        };
        sort.accept(input);
        printEven.accept(input);
        printOdd.accept(input);

    }
}
