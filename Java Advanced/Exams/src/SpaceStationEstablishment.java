import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        readInput(scanner, matrix);

        boolean isGone = false;
        boolean isCollectedStars = false;
        AtomicInteger stars = new AtomicInteger(0);
        int[] spaceCoordinates = getShipCoordinates(matrix);
        String command = scanner.nextLine();

        while (!isGone) {
            switch (command) {
                case "left":
                    if (!moveShipLeft(spaceCoordinates, matrix, stars)) {
                        isGone = true;
                    }
                    break;
                case "right":
                    if (!moveShipRight(spaceCoordinates, matrix, stars)) {
                        isGone = true;
                    }
                    break;
                case "up":
                    if (!moveShipUp(spaceCoordinates, matrix, stars)) {
                        isGone = true;
                    }
                    break;

                case "down":
                    if (!moveShipDown(spaceCoordinates, matrix, stars)) {
                        isGone = true;
                    }
                    break;
            }
            if (isGone) {
                break;
            }
            if (stars.get() >= 50) {
                isCollectedStars = true;
                break;
            }
            spaceCoordinates = getShipCoordinates(matrix);
            command = scanner.nextLine();
        }

        removeSpaceShip(matrix, isGone);

        if (isCollectedStars) {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        } else if (isGone) {
            System.out.println("Bad news, the spaceship went to the void.");
        }
        System.out.println("Star power collected: " + stars.get());
        printMatrix(matrix);
    }

    private static void removeSpaceShip(String[][] matrix, boolean isGone) {
        int[] spaceCoordinates;
        if(isGone) {
            spaceCoordinates = getShipCoordinates(matrix);
            int x = spaceCoordinates[0];
            int y = spaceCoordinates[1];
            matrix[x][y] = "-";
        }
    }

    private static int[] getHoleCoordinates(String[][] matrix, int x, int i) {
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                if (matrix[j][k].equals("O")) {
                    if (j != x || k != i) {
                        return new int[]{j, k};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean moveShipLeft(int[] spaceCoordinates,
                                        String[][] matrix, AtomicInteger stars) {
        int x = spaceCoordinates[0];
        int y = spaceCoordinates[1];
        if (y - 1 >= 0 && y - 1 < matrix[x].length) {
            matrix[x][y] = "-";
            String currentVal = matrix[x][y - 1];
            matrix[x][y - 1] = "S";
            if (Character.isDigit(currentVal.charAt(0))) {
                stars.addAndGet(Integer.parseInt(currentVal));
            } else if (currentVal.equals("O")) {
                int[] holeCoordinates = getHoleCoordinates(matrix, x, y - 1);
                int holeX = holeCoordinates[0];
                int holeY = holeCoordinates[1];
                matrix[x][y - 1] = "-";
                matrix[holeX][holeY] = "S";
            }
        } else {
            return false;
        }
        return true;
    }


    private static boolean moveShipRight(int[] spaceCoordinates,
                                         String[][] matrix, AtomicInteger stars) {
        int x = spaceCoordinates[0];
        int y = spaceCoordinates[1];
        if (y + 1 >= 0 && y + 1 < matrix[x].length) {
            matrix[x][y] = "-";
            String currentVal = matrix[x][y + 1];
            matrix[x][y + 1] = "S";
            if (Character.isDigit(currentVal.charAt(0))) {
                stars.addAndGet(Integer.parseInt(currentVal));
            } else if (currentVal.equals("O")) {
                int[] holeCoordinates = getHoleCoordinates(matrix, x, y + 1);
                int holeX = holeCoordinates[0];
                int holeY = holeCoordinates[1];
                matrix[x][y + 1] = "-";
                matrix[holeX][holeY] = "S";
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean moveShipUp(int[] spaceCoordinates,
                                      String[][] matrix, AtomicInteger stars) {
        int x = spaceCoordinates[0];
        int y = spaceCoordinates[1];
        if (x - 1 >= 0 && x - 1 < matrix.length) {
            matrix[x][y] = "-";
            String currentVal = matrix[x - 1][y];
            matrix[x - 1][y] = "S";
            if (Character.isDigit(currentVal.charAt(0))) {
                stars.addAndGet(Integer.parseInt(currentVal));
            } else if (currentVal.equals("O")) {
                int[] holeCoordinates = getHoleCoordinates(matrix, x - 1, y);
                int holeX = holeCoordinates[0];
                int holeY = holeCoordinates[1];
                matrix[x - 1][y] = "-";
                matrix[holeX][holeY] = "S";
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean moveShipDown(int[] spaceCoordinates,
                                        String[][] matrix, AtomicInteger stars) {
        int x = spaceCoordinates[0];
        int y = spaceCoordinates[1];
        if (x + 1 >= 0 && x + 1 < matrix.length) {
            matrix[x][y] = "-";
            String currentVal = matrix[x + 1][y];
            matrix[x + 1][y] = "S";
            if (Character.isDigit(currentVal.charAt(0))) {
                stars.addAndGet(Integer.parseInt(currentVal));
                matrix[x + 1][y] = "S";
            } else if (currentVal.equals("O")) {
                int[] holeCoordinates = getHoleCoordinates(matrix, x + 1, y);
                int holeX = holeCoordinates[0];
                int holeY = holeCoordinates[1];
                matrix[x + 1][y] = "-";
                matrix[holeX][holeY] = "S";
            }
        } else {
            return false;
        }
        return true;
    }

    private static void readInput(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }

    private static int[] getShipCoordinates(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String e : row) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
