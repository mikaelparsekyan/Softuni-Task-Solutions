import java.util.*;

public class Concert {
    static class Band {
        int time;
        List<String> members = new ArrayList<>();

        public Band(int time, List<String> members) {
            this.time = time;
            this.members = members;
        }

        public int getTime() {
            return time;
        }

        public List<String> getMembers() {
            return members;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Band> bandMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!"start of concert".equals(input)) {
            String[] elements = input.split("; ");
            String command = elements[0];
            String bandName = elements[1];
            if ("Add".equals(command)) {
                addBand(bandMap, elements[2], bandName);
            } else if ("Play".equals(command)) {
                playBand(bandMap, elements[2], bandName);
            }
            input = scanner.nextLine();
        }
        int totalTime = 0;
        for (Map.Entry<String, Band> entry : bandMap.entrySet()) {
            totalTime += entry.getValue().getTime();
        }
        System.out.println("Total time: " + totalTime);
        bandMap.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().getTime(), a.getValue().getTime());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(entry -> {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue().getTime());
        });
        String bandToPrint = scanner.nextLine();
        Band printedBand = bandMap.get(bandToPrint);
        if (printedBand != null) {
            System.out.println(bandToPrint);
            for (String member : printedBand.getMembers()) {
                System.out.printf("=> %s%n",member);
            }

        }
    }

    private static void playBand(Map<String, Band> bandMap, String element, String bandName) {
        int time = Integer.parseInt(element);
        Band band = bandMap.get(bandName);
        if (band == null) {
            band = new Band(time, new ArrayList<>());
            bandMap.put(bandName, band);
        } else {
            int currentTime = band.getTime();
            bandMap.put(bandName, new Band(currentTime + time,
                    band.getMembers()));
        }
    }

    private static void addBand(Map<String, Band> bandMap, String element, String bandName) {
        String[] members = element.split(", ");
        Band currentBand = bandMap.get(bandName);
        if (currentBand == null) {
            currentBand = new Band(0, new ArrayList<>(Arrays.asList(members)));
            bandMap.put(bandName, currentBand);
        } else {
            for (int i = 0; i < members.length; i++) {
                if (!currentBand.getMembers().contains(members[i])) {
                    currentBand.getMembers().add(members[i]);
                }
            }
            bandMap.put(bandName, bandMap.get(bandName));
        }
    }
}
