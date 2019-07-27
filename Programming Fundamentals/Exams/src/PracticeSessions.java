import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> roadAndRoad = new HashMap<>();
        while (!"END".equals(input)) {
            String[] elements = input.split("->");
            String commandType = elements[0];
            switch (commandType) {
                case "Add":
                    addRacer(roadAndRoad, elements);
                    break;
                case "Move":
                    List<String> currentRacers = roadAndRoad.get(elements[1]);
                    if (currentRacers != null) {
                        if (currentRacers.contains(elements[2])) {
                            currentRacers.remove(elements[2]);
                            roadAndRoad.put(elements[1], currentRacers);
                            List<String> nextRoadRacers = roadAndRoad.get(elements[3]);
                            nextRoadRacers.add(elements[2]);
                            roadAndRoad.put(elements[3], nextRoadRacers);
                        }
                    }
                    break;
                case "Close":
                    roadAndRoad.remove(elements[1]);
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.println("Practice sessions:");
        roadAndRoad.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().size(), a.getValue().size());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(a->{
            System.out.println(a.getKey());
            for (String s : a.getValue()) {
                System.out.printf("++%s%n",s);
            }

        });

    }

    private static void addRacer(Map<String, List<String>> roadAndRoad, String[] elements) {
        List<String> road = roadAndRoad.get(elements[1]);
        if (road == null) {
            road = new ArrayList<>(Arrays.asList(elements[2]));
            roadAndRoad.put(elements[1], road);
        } else {
            road.add(elements[2]);
            roadAndRoad.put(elements[1], road);
        }
    }
}
