import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[params[0]][params[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        char charToReplace = scanner.nextLine().charAt(0);

        int[] valueParams = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int row = valueParams[0] - 1;
        int col = valueParams[1] - 1;
        String value = "";
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {
            value = matrix[row][col];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(value)) {
                    matrix[i][j] = charToReplace + "";
                }
            }
        }
        for (String[] r : matrix) {
            for (String element : r) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static void removeValue(String[][] matrix, String value, char charToReplace) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(value)) {
                    matrix[i][j] = charToReplace + "";
                }
            }
        }
    }

    private static void checkIfValid(String[][] matrix, int row, int col) {
        if (row >= 0 && row < matrix.length) {

        }
    }
}
