package CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            Car car = new Car(elements[0],elements[1],
                    Integer.parseInt(elements[2]));
            System.out.println(car.toString());
        }
    }
}
