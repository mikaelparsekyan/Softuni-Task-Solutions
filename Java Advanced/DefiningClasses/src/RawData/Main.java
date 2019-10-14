package RawData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            Engine engine = new Engine(Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(Integer.parseInt(input[3]),
                    input[4]);
            Tire frontLeftTire = new Tire(Double.parseDouble(input[5]),
                    Integer.parseInt(input[6]));
            Tire frontRightTire = new Tire(Double.parseDouble(input[7]),
                    Integer.parseInt(input[8]));
            Tire backLeftTire = new Tire(Double.parseDouble(input[9]),
                    Integer.parseInt(input[10]));
            Tire backRightTire = new Tire(Double.parseDouble(input[11]),
                    Integer.parseInt(input[12]));
            Car currentCar = new Car(model, engine, cargo, frontLeftTire,
                    frontRightTire, backLeftTire, backRightTire);
            cars.add(currentCar);
        }
        String cargoType = scanner.nextLine();
        cars.stream()
                .filter(e -> {
                    if (cargoType.equals("flamable") && e.getEngine().enginePower > 250) {
                        return true;
                    } else if (cargoType.equals("fragile") && e.isAllPressureValid()) {
                        return true;
                    }
                    return false;
                })
                .forEach(e -> System.out.println(e.getModel()));
    }
}
