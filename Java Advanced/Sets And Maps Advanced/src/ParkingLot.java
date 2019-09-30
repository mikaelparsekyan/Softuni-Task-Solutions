import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> cars = new HashSet<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] elements = input.split(", ");
            String command = elements[0];
            String carNumber = elements[1];
            if ("IN".equals(command)) {
                cars.add(carNumber);
            } else if ("OUT".equals(command)) {
                cars.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }

        }
    }
}
