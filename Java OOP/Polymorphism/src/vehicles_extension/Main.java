package vehicles_extension;


import vehicles_extension.models.Bus;
import vehicles_extension.models.Car;
import vehicles_extension.models.Truck;
import vehicles_extension.models.Vehicle;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        String[] carData = input.readLineAsArray();
        String[] truckData = input.readLineAsArray();
        String[] busData = input.readLineAsArray();

        Vehicle car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]),
                Integer.parseInt(carData[3]));

        Vehicle truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]),
                Integer.parseInt(truckData[3]));

        Vehicle bus = new Bus(Double.parseDouble(busData[1]),
                Double.parseDouble(busData[2]),
                Integer.parseInt(busData[3]));

        int n = input.readNextNumber();

        for (int i = 0; i < n; i++) {
            String[] command = input.readLineAsArray();
            switch (command[1]) {
                case "Car":
                    switchCommands(car, command);
                    break;
                case "Truck":
                    switchCommands(truck, command);
                    break;
                case "Bus":
                    switchCommands(bus, command);
            }

        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    private static void switchCommands(Vehicle vehicle, String[] command) {
        if (command[0].equals("Drive")) {
            vehicle.drive(Double.parseDouble(command[2]));
        } else if (command[0].endsWith("Refuel")) {
            vehicle.refuel(Double.parseDouble(command[2]));
        } else if (vehicle.getClass().getSimpleName().equals("Bus")) {
            if (command[0].equals("DriveEmpty")) {
                vehicle.setEmpty(true);
                vehicle.drive(Double.parseDouble(command[2]));
            }
        }
    }
}
