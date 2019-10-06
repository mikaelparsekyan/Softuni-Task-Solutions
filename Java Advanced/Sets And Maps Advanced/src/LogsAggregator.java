import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeSet<String>> userIpAddresses = new HashMap<>();
        Map<String, Integer> userDurations = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ipAddress = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            addIpAddress(userIpAddresses, ipAddress, user);
            addUserDurations(userDurations, user, duration);
        }
        userDurations.entrySet().stream().forEach(e -> {
            System.out.printf("%s: %d " +
                    userIpAddresses.get(e.getKey()) + System.lineSeparator(), e.getKey(), e.getValue());
        });
    }

    private static void addUserDurations(Map<String, Integer> userDurations, String user, int duration) {
        if (userDurations.containsKey(user)) {
            userDurations.put(user, userDurations.get(user) + duration);
        } else {
            userDurations.put(user, duration);
        }
    }

    private static void addIpAddress(Map<String, TreeSet<String>> userIpAddresses, String ipAddress, String user) {
        TreeSet<String> ipAddresses = new TreeSet<>();
        if (userIpAddresses.containsKey(user)) {
            ipAddresses = userIpAddresses.get(user);
            ipAddresses.add(ipAddress);
        }
        ipAddresses.add(ipAddress);
        userIpAddresses.put(user, ipAddresses);
    }
}
