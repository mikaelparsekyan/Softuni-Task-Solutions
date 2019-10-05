import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            LinkedHashMap<String, List<String>> countryAndCity = new LinkedHashMap<>();
            List<String> cities = new ArrayList<>();

            if (continents.containsKey(continent)) {
                countryAndCity = continents.get(continent);
                if (countryAndCity.containsKey(country)) {
                    cities = countryAndCity.get(country);
                    cities.add(city);
                } else {
                    cities.add(city);
                }
                countryAndCity.put(country, cities);
            } else {
                cities.add(city);
                countryAndCity.put(country, cities);
            }
            continents.put(continent, countryAndCity);
        }
        continents.entrySet().stream().forEach(entry -> {
            System.out.printf("%s:%n", entry.getKey());
            entry.getValue().entrySet().stream().forEach(value -> {
                System.out.printf("  %s -> %s%n", value.getKey(),
                        String.join(", ", value.getValue()));
            });
        });
    }
}
