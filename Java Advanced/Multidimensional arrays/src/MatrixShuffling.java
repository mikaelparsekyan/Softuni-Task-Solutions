import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = params[0];
        int cols = params[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            boolean isInputValid = true;
            String[] elements = command.split(" ");
            if (elements.length == 5) {
                int row1 = Integer.parseInt(elements[1]);
                int col1 = Integer.parseInt(elements[2]);
                int row2 = Integer.parseInt(elements[3]);
                int col2 = Integer.parseInt(elements[4]);

                if (checkCoordinates(matrix, row1, col1, row2, col2)) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    printMatrix(matrix);
                } else {
                    isInputValid = false;
                }
            } else {
                isInputValid = false;
            }
            if (!isInputValid) {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkCoordinates(String[][] matrix, int row1, int col1, int row2, int col2) {
        return checkRow(matrix, row1) && checkRow(matrix, row2)
                && checkCol(matrix, col1) && checkCol(matrix, col2);
    }

    private static boolean checkRow(String[][] matrix, int value) {
        return value >= 0 && value < matrix.length;
    }

    private static boolean checkCol(String[][] matrix, int value) {
        return value >= 0 && value < matrix[0].length;
    }
}
