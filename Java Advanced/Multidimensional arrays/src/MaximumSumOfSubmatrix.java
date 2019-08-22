import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sum = new int[1];
        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[arr[0]][arr[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int[] row : getMaxSubmatrix(matrix,sum)) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println(sum[0]);

    }

    private static int[][] getMaxSubmatrix(int[][] matrix, int[] sum) {
        int[][] maxSumSubmatrix = new int[2][2];
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            if (row + 1 < matrix.length) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (col + 1 < matrix[row].length) {
                        int currentSum = matrix[row][col] + matrix[row][col + 1]
                                + matrix[row + 1][col] + matrix[row + 1][col + 1];
                        if (currentSum > maxSum) {
                            maxSum = currentSum;

                            for (int i = 0; i < maxSumSubmatrix.length; i++) {
                                for (int j = 0; j < maxSumSubmatrix[i].length; j++) {
                                    maxSumSubmatrix[i][j] = matrix[row+i][col+j];
                                }
                            }
                        }
                    }
                }
            }
        }
        sum[0] = maxSum;
        return maxSumSubmatrix;
    }
}
