import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .collect(Collectors.toList());
        String info = scanner.nextLine();
        String nameRegex = "(?<name>[A-Za-z])+";
        String distanceRegex = "(?<distance>[0-9])";
        Map<String, Integer> racers = new LinkedHashMap<>();
        while (!"end of race".equals(info)) {
            String name = findName(nameRegex, info);
            int distance = findDistance(distanceRegex, info);
            //System.out.println(name + " " + distance);
            if (names.contains(name.toString())) {

                if (racers.containsKey(name)) {
                    int currentDistance = racers.get(name);
                    racers.put(name, currentDistance + distance);
                } else {
                    racers.put(name, distance);
                }
            }

            info = scanner.nextLine();
        }
        final int[] place = {1};
        String[] values = new String[]{"st","nd","rd"};
        racers.entrySet().stream().sorted((racer1,racer2)->{
            return racer2.getValue().compareTo(racer1.getValue());
        }).limit(3).forEach(racer->{
            System.out.printf("%d%s place: %s%n", place[0],values[place[0]-1],racer.getKey());
            place[0]++;
        });


    }

    private static String findName(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder name = new StringBuilder();
        while (matcher.find()) {
            name.append(matcher.group(0));
        }
        return name.toString();
    }

    private static int findDistance(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int distance = 0;
        while (matcher.find()) {
            distance += Integer.parseInt(matcher.group(0));
        }
        return distance;
    }
}
