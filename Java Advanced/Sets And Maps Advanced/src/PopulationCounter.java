import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> populationMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] elements = input.split("\\|");
            String city = elements[0];
            String country = elements[1];
            long population = Long.parseLong(elements[2]);

            LinkedHashMap<String, Long> cityAndPopulation = new LinkedHashMap<>();

            if (populationMap.containsKey(country)) {
                cityAndPopulation = populationMap.get(country);
                cityAndPopulation.put(city, population);
            } else {
                cityAndPopulation.put(city, population);
            }
            populationMap.put(country, cityAndPopulation);

            input = scanner.nextLine();
        }
        populationMap.entrySet().stream()
                .sorted((a, b) -> {
                    return Long.compare(sumPopulation(b.getValue()),
                            sumPopulation(a.getValue()));
                })
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n",
                            e.getKey(), sumPopulation(e.getValue()));
                    e.getValue().entrySet().stream().sorted(
                            (a, b) -> {
                                return b.getValue().compareTo(a.getValue());
                            }
                    ).forEach(val -> {
                        System.out.printf("=>%s: %d%n", val.getKey(), val.getValue());
                    });
                });
    }

    private static long sumPopulation(LinkedHashMap<String, Long> map) {
        long population = 0;
        for (var entry : map.entrySet()) {
            population += entry.getValue();
        }
        return population;
    }
}
