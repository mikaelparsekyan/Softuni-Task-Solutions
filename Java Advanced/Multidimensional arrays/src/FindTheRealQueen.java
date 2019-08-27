import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }
        printQueenCoordinates(matrix);
    }

    private static void printQueenCoordinates(char[][] matrix) {
        int[] queenCoordinates = new int[2];
        List<int[]> coordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'q') {
                    coordinates.add(new int[]{i, j});
                }
            }
        }
        for (int[] values : coordinates) {
            boolean isValid = true;
            for (int[] coordinate : coordinates) {
                if (!(values[0] == coordinate[0] && values[1] == coordinate[1])) {
                    if (values[0] == coordinate[0] || values[1] == coordinate[1]) {
                        isValid = false;
                    } else {
                        if (!checkDiagonals(values[0], values[1], coordinate[0], coordinate[1])) {
                            isValid = false;
                        }
                    }
                }
            }
            if (isValid) {
                queenCoordinates[0] = values[0];
                queenCoordinates[1] = values[1];
            }
        }

        System.out.println(queenCoordinates[0] + " " + queenCoordinates[1]);

    }

    private static boolean checkDiagonals(int queenX, int queenY, int x2, int y2) {
        int xAbs = Math.abs(queenX - x2);
        int yAbs = Math.abs(queenY - y2);
        if (xAbs == yAbs) {
            return false;
        }
        return true;
    }
}
