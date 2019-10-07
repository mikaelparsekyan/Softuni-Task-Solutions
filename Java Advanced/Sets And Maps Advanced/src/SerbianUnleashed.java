import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> venueMap = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(
                "(?<name>.*) @(?<venue>.*) (?<ticketsPrice>[0-9]+) (?<ticketsCount>[0-9]+)");
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singerName = matcher.group("name");
                String venue = matcher.group("venue");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                int income = ticketsCount * ticketsPrice;
                addValue(venueMap, singerName, venue, income);
            }

            input = scanner.nextLine();
        }
        venueMap.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted((a, b) -> {
                return b.getValue().compareTo(a.getValue());
            }).forEach(val -> {
                System.out.printf("#  %s -> %d%n",val.getKey(),val.getValue());
            });
        });
    }

    private static void addValue(Map<String, Map<String, Integer>> venueMap, String singerName, String venue, int income) {
        Map<String, Integer> singersAndIncome = new LinkedHashMap<>();
        if (venueMap.containsKey(venue)) {
            singersAndIncome = venueMap.get(venue);
            if (singersAndIncome.containsKey(singerName)) {
                singersAndIncome.put(singerName,
                        singersAndIncome.get(singerName) + income);
            } else {
                singersAndIncome.put(singerName, income);
            }
        } else {
            singersAndIncome.put(singerName, income);
        }
        venueMap.put(venue, singersAndIncome);
    }
}
