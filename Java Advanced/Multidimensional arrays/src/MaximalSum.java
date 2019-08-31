import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = params[0];
        int m = params[1];
        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[][] result = findMaxMatrix(matrix);

        System.out.println("Sum = " + sumElementsMatrix(result));
        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }

    private static int[][] findMaxMatrix(int[][] matrix) {
        int[][] currentMatrix = new int[3][3];
        int[][] maxMatrix = new int[3][3];
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row <= matrix.length - 3; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {
                for (int subMatrixRow = 0; subMatrixRow < 3; subMatrixRow++) {
                    for (int subMatrixCol = 0; subMatrixCol < 3; subMatrixCol++) {
                        currentMatrix[subMatrixRow][subMatrixCol] =
                                matrix[row + subMatrixRow][col + subMatrixCol];
                    }
                }
                int currentSum = sumElementsMatrix(currentMatrix);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    for (int i = 0; i < maxMatrix.length; i++) {
                        maxMatrix[i] = currentMatrix[i].clone();
                    }
                }
            }
        }

        return maxMatrix;
    }

    private static int sumElementsMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
