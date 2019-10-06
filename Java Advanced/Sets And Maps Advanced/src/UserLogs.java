import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();
        Pattern pattern = Pattern.compile("IP=(?<ip>.*)\\s.*\\suser=(?<user>.*)");
        String input = scanner.nextLine();
        while (!"end".equals(input)) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String ipAddress = matcher.group("ip");
                String username = matcher.group("user");
                LinkedHashMap<String, Integer> ipOccurTimes = new LinkedHashMap<>();
                if (userLogs.containsKey(username)) {
                    ipOccurTimes = userLogs.get(username);
                    if (ipOccurTimes.containsKey(ipAddress)) {
                        ipOccurTimes.put(ipAddress,
                                ipOccurTimes.get(ipAddress) + 1);
                    } else {
                        ipOccurTimes.put(ipAddress, 1);
                    }
                } else {
                    ipOccurTimes.put(ipAddress, 1);
                }
                userLogs.put(username, ipOccurTimes);
            }
            input = scanner.nextLine();
        }
        userLogs.entrySet().stream().forEach(e -> {
            System.out.printf("%s: %n", e.getKey());
            StringBuilder result = new StringBuilder();
            for (var entry : e.getValue().entrySet()) {
                result.append(String.format("%s => %d, ",
                        entry.getKey(), entry.getValue()));
            }
            String resultToString = result.toString();
            resultToString = resultToString.substring(0, resultToString.length() - 2);
            resultToString += ".";
            System.out.println(resultToString);
        });
    }
}

