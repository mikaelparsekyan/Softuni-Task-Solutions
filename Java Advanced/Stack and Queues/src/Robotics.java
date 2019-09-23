import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ROB-15;SS2-10;NX8000-3
        String[] inputRobots = scanner.nextLine().split(";");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Map<String, Integer> robots = new LinkedHashMap<>();
        int[] robotsProcessTime = new int[inputRobots.length];

        for (int i = 0; i < inputRobots.length; i++) {
            String[] robotsAndTimes = inputRobots[i].split("-");
            robots.put(robotsAndTimes[0], Integer.parseInt(robotsAndTimes[1]));
        }
        int[] time = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        LocalTime localTime = LocalTime.of(time[0],time[1],time[2]);

        String product = scanner.nextLine();

        while (!"End".equals(product)) {
            queue.offer(product);
            product = scanner.nextLine();
        }
        long timeSec = 0;
        while (!queue.isEmpty()) {
            String item = queue.poll();
            localTime = localTime.plusSeconds(1);
            for (int i = 0; i < robotsProcessTime.length; i++) {
                if (robotsProcessTime[i] > 0) {
                    robotsProcessTime[i]--;
                }

            }
            boolean isFree = true;
            int i = 0;
            for (var robot : robots.entrySet()) {
                if (robotsProcessTime[i] == 0) {
                    robotsProcessTime[i] = robot.getValue();
                    printResult(robot.getKey(),item,localTime);
                    isFree = false;
                    break;
                }
                i++;
            }
            if(isFree){
                queue.offer(item);
            }

        }
    }

    private static void printResult(String robot, String item, LocalTime time) {
        System.out.printf("%s - %s [%02d:%02d:%02d]%n",robot,item,time.getHour(),time.getMinute(),time.getSecond());
    }
}
