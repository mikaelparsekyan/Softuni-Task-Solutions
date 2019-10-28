package trafficLights;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrafficLights[] lights = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(s -> new TrafficLights(Signal.valueOf(s)))
                .toArray(TrafficLights[]::new);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (TrafficLights light : lights) {
                light.changeLight();
                System.out.print(light.toString() + " ");
            }
            System.out.println();
        }
    }
}
