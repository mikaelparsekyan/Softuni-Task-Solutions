import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = readMatrix(params[0], params[1], scanner);

        printDiagonals(matrix);
    }

    private static void printDiagonals(int[][] matrix) {

        for (int y = matrix[0].length - 1; y >= 0; y--) {
            int yCopy = y;
            for (int x = matrix.length - 1; x >= 0; x--) {
                if (yCopy >= 0 && yCopy < matrix[0].length) {
                    System.out.print(matrix[x][yCopy] + " ");
                }
                yCopy++;
            }
            System.out.println();

        }

        for (int x = matrix.length - 2; x >= 0; x--) {
            int xCopy = x;
            for (int y = 0; y < matrix[0].length; y++) {
                if (xCopy >= 0 && xCopy < matrix.length) {
                    System.out.print(matrix[xCopy][y] + " ");
                }
                xCopy--;
            }
            System.out.println();

        }
    }

        private static int[][] readMatrix ( int row, int col, Scanner scanner){
            int[][] matrix = new int[row][col];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            return matrix;
        }
    }
