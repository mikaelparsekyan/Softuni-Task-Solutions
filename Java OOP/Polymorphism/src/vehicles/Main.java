package vehicles;

import vehicles.models.Car;
import vehicles.models.Truck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        String[] truckData = scanner.nextLine().split("\\s+");


        Car car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]));
        Truck truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[1]) {
                case "Car":
                    if (command[0].equals("Drive")) {
                        car.drive(Double.parseDouble(command[2]));
                    } else {
                        car.refuel(Double.parseDouble(command[2]));
                    }
                    break;
                case "Truck":
                    if (command[0].equals("Drive")) {
                        truck.drive(Double.parseDouble(command[2]));
                    } else {
                        truck.refuel(Double.parseDouble(command[2]));
                    }
                    break;
            }
        }
        System.out.printf("Car: %.2f" + System.lineSeparator(), car.getFuelQuantity());
        System.out.printf("Truck: %.2f", truck.getFuelQuantity());

    }
}
