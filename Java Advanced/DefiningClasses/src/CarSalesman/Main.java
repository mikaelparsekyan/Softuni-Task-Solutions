package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engineMap = new LinkedHashMap<>();
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] engineInput = scanner.nextLine().split("\\s+");
            Engine currentEngine = null;
            if (engineInput.length == 2) {
                currentEngine = new Engine(engineInput[0],
                        Integer.parseInt(engineInput[1]));
            } else if (engineInput.length == 3) {
                currentEngine = new Engine(engineInput[0],
                        Integer.parseInt(engineInput[1]), engineInput[2]);
            } else if (engineInput.length == 4) {
                currentEngine = new Engine(engineInput[0],
                        Integer.parseInt(engineInput[1]),
                        Integer.parseInt(engineInput[2]),
                        engineInput[3]);
            }
            engineMap.put(engineInput[0], currentEngine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carInput = scanner.nextLine().split("\\s+");
            Car car = null;
            if (carInput.length == 2) {
                car = new Car(carInput[0], engineMap.get(carInput[1]));
            } else if (carInput.length == 3) {
                car = new Car(carInput[0], engineMap.get(carInput[1]), carInput[2]);
            } else if (carInput.length == 4) {
                car = new Car(carInput[0], engineMap.get(carInput[1]),
                        Integer.parseInt(carInput[2]), carInput[3]);
            }
            cars.add(car);
        }
        for (int i = 0; i < cars.size(); i++) {

            System.out.print(cars.get(i).toString());

        }

    }
}
