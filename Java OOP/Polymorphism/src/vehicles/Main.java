package vehicles;

import vehicles.models.Car;
import vehicles.models.Truck;
import vehicles.models.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = readLine(scanner);
        String[] truckData = readLine(scanner);


        Car car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]));
        
        Truck truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = readLine(scanner);
            switch (command[1]) {
                case "Car":
                    switchCommands(car, command);
                    break;
                case "Truck":
                    switchCommands(truck, command);
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());

    }

    private static void switchCommands(Vehicle vehicle, String[] command) {
        if (command[0].equals("Drive")) {
            vehicle.drive(Double.parseDouble(command[2]));
        } else {
            vehicle.refuel(Double.parseDouble(command[2]));
        }
    }

    private static String[] readLine(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
