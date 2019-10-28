package pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] points = readArray(scanner);
        Point bottomLeftPoint = new Point(points[0], points[1]);
        Point topRightPoint = new Point(points[2], points[3]);

        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] input = readArray(scanner);
            Point currentPoint = new Point(input[0], input[1]);

            System.out.println(rectangle.contains(currentPoint));
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
