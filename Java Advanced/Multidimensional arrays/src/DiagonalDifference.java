import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(Math.abs(sumLeft(matrix) - sumRight(matrix)));
    }

    private static int sumLeft(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int sumRight(int[][] matrix) {
        int sum = 0;
        int row = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[row][i];
            row++;
        }
        return sum;
    }
}
