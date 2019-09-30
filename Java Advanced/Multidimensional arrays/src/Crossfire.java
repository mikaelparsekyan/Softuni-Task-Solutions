import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = fillMatrix(params[0], params[1]);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] array = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
                destroyCells(matrix, array[0], array[1], array[2]);
            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean checkIndex(List<List<Integer>> matrix, int x, int y) {
        return (x >= 0 && x < matrix.size()) &&
                (y >= 0 && y < matrix.get(x).size());
    }

    private static void destroyCells(List<List<Integer>> matrix, int x,
                                     int y, int radius) {
        for (int i = x - radius; i <= x + radius; i++) {
            if (checkIndex(matrix,i,y) && i != x) {
                matrix.get(i).remove(y);
            }
        }
        for (int i = y + radius; i >= y - radius; i--) {
            if (checkIndex(matrix,x,i)) {
                matrix.get(x).remove(i);
            }
        }
        matrix.removeIf(List::isEmpty);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> fillMatrix(int row, int col) {
        List<List<Integer>> matrix = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < row; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < col; j++) {
                matrix.get(i).add(num++);
            }
        }
        return matrix;
    }
}
