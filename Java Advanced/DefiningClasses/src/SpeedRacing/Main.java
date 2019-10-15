package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            Car currentCar = new Car(elements[0],
                    Double.parseDouble(elements[1]),
                    Double.parseDouble(elements[2]));
            cars.put(elements[0], currentCar);
        }
        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] elements = command.split("\\s+");
            String model = elements[1];
            int distance = Integer.parseInt(elements[2]);
            Car car = cars.get(model);
            double fuelAmount = car.getFuelAmount();
            double price = car.getFuelPrice();
            double total = distance * price;
            if (fuelAmount - total >= 0) {
                car.setFuelAmount(fuelAmount - total);
                car.setDistance(car.getDistance() + distance);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }
        cars.entrySet().stream().forEach(e -> {

            System.out.printf("%s %.2f %d%n", e.getValue().model,
                    e.getValue().getFuelAmount(), e.getValue().getDistance());

        });
    }
}
