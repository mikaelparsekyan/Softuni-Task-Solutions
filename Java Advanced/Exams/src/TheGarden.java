import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> vegetables = new LinkedHashMap<>();
        assignValuesVegetables(vegetables);

        int rows = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        String command = scanner.nextLine();
        while (!"End of Harvest".equals(command)) {
            String[] elements = command.split("\\s+");
            String commandType = elements[0];
            int row = Integer.parseInt(elements[1]);
            int col = Integer.parseInt(elements[2]);
            switch (commandType) {
                case "Harvest":
                    harveVegetable(matrix, row, col, vegetables);
                    break;
                case "Mole":
                    String direction = elements[3];
                    moleVegetable(matrix, row, col, direction, vegetables);
                    break;
            }

            command = scanner.nextLine();
        }
        print(matrix, vegetables);
    }

    private static void assignValuesVegetables(Map<String, Integer> vegetables) {
        vegetables.put("Carrots", 0);
        vegetables.put("Potatoes", 0);
        vegetables.put("Lettuce", 0);
        vegetables.put("Other", 0);
    }

    private static void moleVegetable(String[][] matrix, int row,
                                      int col, String direction, Map<String, Integer> vegetables) {
        switch (direction) {
            case "left":
                moveLeft(matrix, row, col, vegetables);
                break;
            case "right":
                moveRight(matrix, row, col, vegetables);
                break;
            case "up":
                moveUp(matrix, row, col, vegetables);
                break;
            case "down":
                moveDown(matrix, row, col, vegetables);

                break;
        }
    }

    private static void moveLeft(String[][] matrix, int row, int col, Map<String, Integer> vegetables) {
        if (vegetableExists(matrix, row, col)) {
            for (int i = col; i >= 0; i -= 2) {
                if (!matrix[row][i].equals(" ")) {
                    matrix[row][i] = " ";
                    vegetables.put("Other", vegetables.get("Other") + 1);
                }
            }
        }
    }

    private static void moveRight(String[][] matrix, int row, int col, Map<String, Integer> vegetables) {
        if (vegetableExists(matrix, row, col)) {
            for (int i = col; i < matrix[row].length; i += 2) {
                if (!matrix[row][i].equals(" ")) {
                    matrix[row][i] = " ";
                    vegetables.put("Other", vegetables.get("Other") + 1);
                }
            }
        }
    }


    private static void moveUp(String[][] matrix, int row, int col, Map<String, Integer> vegetables) {
        if (vegetableExists(matrix, row, col)) {
            for (int i = row; i >= 0; i -= 2) {
                if (!matrix[i][col].equals(" ")) {
                    matrix[i][col] = " ";
                    vegetables.put("Other", vegetables.get("Other") + 1);
                }
            }
        }
    }

    private static void moveDown(String[][] matrix, int row, int col, Map<String, Integer> vegetables) {
        if (vegetableExists(matrix, row, col)) {
            for (int i = row; i < matrix.length; i += 2) {
                if (!matrix[i][col].equals(" ")) {
                    matrix[i][col] = " ";
                    vegetables.put("Other", vegetables.get("Other") + 1);
                }
            }
        }
    }

    private static void harveVegetable(String[][] matrix,
                                       int row, int col, Map<String, Integer> vegetables) {
        if (vegetableExists(matrix, row, col)) {
            switch (matrix[row][col]) {
                case "L":
                    vegetables.put("Lettuce",
                            vegetables.get("Lettuce") + 1);
                    break;
                case "C":
                    vegetables.put("Carrots",
                            vegetables.get("Carrots") + 1);
                    break;
                case "P":
                    vegetables.put("Potatoes",
                            vegetables.get("Potatoes") + 1);
                    break;
            }
            matrix[row][col] = " ";
        }
    }

    private static boolean vegetableExists(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    private static void print(String[][] matrix,
                              Map<String, Integer> vegetables) {
        for (String[] row : matrix) {
            for (String e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        System.out.println("Carrots: " + vegetables.get("Carrots"));
        System.out.println("Potatoes: " + vegetables.get("Potatoes"));
        System.out.println("Lettuce: " + vegetables.get("Lettuce"));
        System.out.println("Harmed vegetables: " + vegetables.get("Other"));
    }
}
