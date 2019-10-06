import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixParams = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[matrixParams[0]][matrixParams[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        for (int i = 0; i < 3; i++) {
            moveBunnies(matrix);
            printMatrix(matrix);
            replaceBunnies(matrix);
            System.out.println("-----------------");
        }
    }

    private static void moveBunnies(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    //moveUp(matrix, i, j);
                    moveDown(matrix,i,j);
//                    moveLeft(matrix,i,j);
//                    moveRight(matrix,i,j);
                }
            }
        }
    }
    private static void replaceBunnies(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'b') {
                   matrix[i][j] = 'B';
                }
            }
        }
    }
    private static void moveUp(char[][] matrix, int r, int c) {
        if (r - 1 >= 0 && r - 1 < matrix.length) {
            matrix[r - 1][c] = 'B';
        }
    }

    private static void moveDown(char[][] matrix, int r, int c) {
        if (r + 1 >= 0 && r + 1 < matrix.length) {
            matrix[r + 1][c] = 'b';
        }
    }

    private static void moveLeft(char[][] matrix, int r, int c) {
        if (c - 1 >= 0 && c - 1 < matrix[r].length) {
            matrix[r][c - 1] = 'B';
        }
    }

    private static void moveRight(char[][] matrix, int r, int c) {
        if (c + 1 >= 0 && c + 1 < matrix[r].length) {
            matrix[r][c + 1] = 'B';
        }
    }
    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }
}
