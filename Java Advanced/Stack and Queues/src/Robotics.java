import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ROB-15;SS2-10;NX8000-3
        String[] input = scanner.nextLine().split(";");
        int len = input.length;

        String[] robotNames = new String[len];
        int[] itemTimes = new int[len];
        int[] workingTime = new int[len];

        for (int i = 0; i < len; i++) {
            String[] elements = input[i].split("-");
            robotNames[i] = elements[0];
            itemTimes[i] = Integer.parseInt(elements[1]);
        }
        int[] time = Arrays.stream(scanner.nextLine()
                .split(":")).mapToInt(Integer::parseInt).toArray();
        LocalTime localTime = LocalTime.of(time[0], time[1], time[2]);
        String product = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!"End".equals(product)) {
            queue.offer(product);
            product = scanner.nextLine();
        }
        while (!queue.isEmpty()) {
            localTime = localTime.plusSeconds(1);
            String item = queue.poll();
            boolean isFree = true;
            for (int i = 0; i < robotNames.length; i++) {
                if (workingTime[i] == 0 && isFree) {
                    isFree = false;
                    workingTime[i] = itemTimes[i];
                    System.out.printf("%s - %s [%02d:%02d:%02d]\n", robotNames[i], item, localTime.getHour(),
                            localTime.getMinute(), localTime.getSecond());
                }

                if (workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }
            if (isFree) {
                queue.offer(item);
            }
        }
    }
}
