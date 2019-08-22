import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        char[][] matrixA = new char[row][col];
        char[][] matrixB = new char[row][col];
        for (int i = 0; i < row; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixA[i][j] = input[j].charAt(0);
            }
        }
        for (int i = 0; i < row; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrixB[i].length; j++) {
                matrixB[i][j] = input[j].charAt(0);
            }
        }
        char[][] outputMatrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrixA[i][j]==matrixB[i][j]){
                    outputMatrix[i][j] = matrixA[i][j];
                } else {
                    outputMatrix[i][j] = '*';
                }
            }
        }
        for (char[] line : outputMatrix) {
            for (char element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }
}
