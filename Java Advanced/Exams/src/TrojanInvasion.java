import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int warriorsWaves = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> plates = new ArrayDeque<>();
        ArrayDeque<Integer> warriors = new ArrayDeque<>();

        for (int i = 1; i <= warriorsWaves; i++) {
            Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .map(Integer::parseInt)
                    .forEach(warriors::push);

            if (i % 3 == 0) {
                plates.offer(Integer.parseInt(scanner.nextLine()));
            }

            while (!warriors.isEmpty() && !plates.isEmpty()) {
                int plate = plates.poll();

                while (plate > 0 && !warriors.isEmpty()) {
                    int warrior = warriors.pop();
                    plate -= warrior;

                    if(plate < 0){
                        warriors.push(Math.abs(plate));
                    }
                }
            }
        }
    }
}
