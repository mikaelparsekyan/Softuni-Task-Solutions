import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(", ");
        int n = Integer.parseInt(params[0]);
        int[][] matrix = new int[n][n];
        switch (params[1]) {
            case "A":
                matrix = patternA(n);
                break;
            case "B":
                matrix = patternB(n);
                break;
        }
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private static int[][] patternA(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = num;
                num++;
            }
        }
        return matrix;
    }

    private static int[][] patternB(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            } else {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = num;
                    num++;
                }
            }

        }
        return matrix;
    }
}
