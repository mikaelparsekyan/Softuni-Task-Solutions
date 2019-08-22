import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int[] diagonal1 = new int[n];
        int[] diagonal2 = new int[n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < diagonal1.length; j++) {
                diagonal1[i] = matrix[i][i];
            }
        }
        int rowIndex = n - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < diagonal2.length; j++) {
                diagonal2[i] = matrix[rowIndex][i];
            }
            rowIndex--;
        }
        for (int i : diagonal1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : diagonal2) {
            System.out.print(i + " ");
        }


    }
}
