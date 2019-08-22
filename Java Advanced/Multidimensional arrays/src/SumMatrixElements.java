import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[arr[0]][arr[1]];
        for (int i = 0; i < arr[0]; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(getSum(matrix));
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;
        for (int[] rows : matrix) {
            for (int element : rows) {
                sum += element;
            }
        }
        return sum;
    }
}
