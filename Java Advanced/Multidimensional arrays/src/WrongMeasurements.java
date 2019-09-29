import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        char[][] validValues = new char[rows][matrix[0].length];
        int[] wrongValues = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int wrongNum = matrix[wrongValues[0]][wrongValues[1]];

        removeValue(matrix, validValues, wrongValues);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongNum) {
                    removeValue(matrix, validValues, new int[]{i, j});
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void removeValue(int[][] matrix, char[][] validValues, int[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];
        int sum = 0;
        int num = matrix[x][y];
        if (x + 1 < matrix.length) {
            int val = matrix[x + 1][y];
            if ((val != num) && (validValues[x + 1][y] != 'x')) {
                sum += val;
            }
        }
        if (x - 1 >= 0) {
            int val = matrix[x - 1][y];
            if ((val != num) && (validValues[x - 1][y] != 'x')) {
                sum += val;
            }
        }
        if (y + 1 < matrix[x].length) {
            int val = matrix[x][y + 1];
            if ((val != num) && (validValues[x][y + 1] != 'x')) {
                sum += val;
            }
        }
        if (y - 1 >= 0) {
            int val = matrix[x][y - 1];
            if ((val != num) && (validValues[x][y - 1] != 'x')) {
                sum += val;
            }
        }
        matrix[x][y] = sum;
        validValues[x][y] = 'x';
    }

}
