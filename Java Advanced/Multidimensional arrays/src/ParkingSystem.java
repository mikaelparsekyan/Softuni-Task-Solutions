import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> parking = new ArrayList<>();
        for (int i = 0; i < params[0]; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < params[1]; j++) {
                line.add(0);
            }
            parking.add(line);
        }

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            List<Integer> array = Arrays.stream(input.split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int z = array.get(0);
            int x = array.get(1);
            int y = array.get(2);
            park(parking, z, x, y);
            //printMatrix(parking);
            input = scanner.nextLine();
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }

    private static void park(List<List<Integer>> parking, int z, int x, int y) {
        int distance = 0;
        if (isSpotFree(parking, x, y)) {
            distance = getDistance(z, x, y);
            parking.get(x).set(y,1);
        } else {
            if (isFreeSpotsAvailable(parking, x)) {
                int[] spotCoordinates = takeClosestSpot(parking, x, y);
                distance = getDistance(z, spotCoordinates[0], spotCoordinates[1]);
            } else {
                System.out.printf("Row %d full%n", x);
                return;
            }
        }
        System.out.println(distance);
    }

    private static int getDistance(int enterRow, int spotRow, int spotCol) {
        int distance = 0;
        distance += Math.abs(spotRow - enterRow);
        distance += spotCol + 1;
        return distance;
    }

    private static int[] takeClosestSpot(List<List<Integer>> parking, int x, int y) {
        for (int i = y - 1; i >= 1; i--) {
            if (parking.get(x).get(i) != 1) {
                parking.get(x).set(i, 1);
                return new int[]{x, i};
            }
        }
        for (int i = y + 1; i < parking.get(x).size(); i++) {
            if (parking.get(x).get(i) != 1) {
                parking.get(x).set(i, 1);
                return new int[]{x, i};
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean isFreeSpotsAvailable(List<List<Integer>> parking, int row) {
        for (int i = 1; i < parking.get(row).size(); i++) {
            if (parking.get(row).get(i) == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSpotFree(List<List<Integer>> parking, int row, int col) {
        return parking.get(row).get(col) != 1;
    }
}
