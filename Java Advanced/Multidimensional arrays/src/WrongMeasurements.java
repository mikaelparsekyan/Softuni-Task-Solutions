import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        int[][] result = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            result[i] = new int[matrix[i].length];
        }
        int[] wrongValues = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int number = matrix[wrongValues[0]][wrongValues[1]];

        while (isContaining(matrix, number)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == number) {
                        removeValue(matrix, result, new int[]{i, j});

                    }
                }
            }
        }
        //removeValue(matrix,result, wrongValues);

        for (int[] ints : result) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    private static boolean isContaining(int[][] matrix, int number) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {

                    return true;
                }
            }
        }
        return false;
    }

    private static void removeValue(int[][] matrix, int[][] newMatrix, int[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];
            int sum = 0;
        int num = matrix[x][y];
        if (x + 1 < matrix.length) {
            int val = matrix[x + 1][y];
            if (val != num) {
                sum += val;
            }
        }
        if (x - 1 >= 0) {
            int val = matrix[x - 1][y];
            if (val != num) {
                sum += val;
            }
        }
        if (y + 1 < matrix[x].length) {
            int val = matrix[x][y + 1];
            if (val != num) {
                sum += val;
            }
        }
        if (y - 1 >= 0) {
            int val = matrix[x][y - 1];
            if (val != num) {
                sum += val;
            }
        }
        newMatrix[x][y] = sum;
    }

}
