import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planet>[a-zA-Z]+)[^@\\-!:>]*:[0-9]+[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Map<String, List<String>> planets = new HashMap<>();
        planets.put("Attacked",new ArrayList<>());
        planets.put("Destroyed",new ArrayList<>());
        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            message = decryptMessage(message);

            Matcher matcher = pattern.matcher(message);
            while (matcher.find()) {
                String attackType = matcher.group("type");
                String type = "";
                if (attackType.equals("A")) {
                    type = "Attacked";
                } else if (attackType.equals("D")) {
                    type = "Destroyed";
                }
                List<String> currentList = planets.get(type);
                if(currentList!=null) {
                    currentList.add(matcher.group("planet"));
                    planets.put(type, currentList);
                }
            }
        }
        planets.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(planet->{
            System.out.printf("%s planets: %d%n",planet.getKey(),planet.getValue().size());
            planet.getValue().stream().sorted((a,b)->{
                return a.compareTo(b);
            }).forEach(a->{
                System.out.printf("-> %s%n",a);
            });

        });
    }

    private static String decryptMessage(String message) {
        String[] letters = {"s", "t", "a", "r"};
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            String currentElement = message.charAt(i) + "";
            for (int j = 0; j < letters.length; j++) {
                if (currentElement.equalsIgnoreCase(letters[j])) {
                    count++;
                }
            }
        }
        for (int i = 0; i < message.length(); i++) {
            result.append((char) (message.charAt(i) - count));
        }
        return result.toString();
    }
}
