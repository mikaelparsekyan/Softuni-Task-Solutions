import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int r = params[0];
        int c = params[1];
        String[][] matrix = new String[r][c];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char firstAndLastChar = (char) (97 + row);
                char middleChar = (char) (97 + row + col);
                System.out.printf("%c%c%c ", firstAndLastChar, middleChar, firstAndLastChar);
            }
            System.out.println();
        }
    }
}
