import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        List<String> filters = new ArrayList<>();
        String input = scanner.nextLine();

        while (!"Print".endsWith(input)) {
            String[] elements = input.split(";");
            String commandType = elements[0];
            if ("Add filter".equals(commandType)) {
                filters.add(elements[1] + " " + elements[2]);
            } else if ("Remove filter".equals(commandType)) {
                filters.remove(elements[1] + " " + elements[2]);
            }
            input = scanner.nextLine();
        }
        for (String filter : filters) {
            String[] elements = filter.split(" ");
            String command = elements[0];
            if (command.equals("Starts")) {
                String start = elements[2];
                people = people.stream().filter(e -> !e.startsWith(start))
                        .collect(Collectors.toList());
            } else if (command.equals("Ends")) {
                String end = elements[2];
                people = people.stream().filter(e -> !e.endsWith(end))
                        .collect(Collectors.toList());
            } else if (command.equals("Length")) {
                int len = Integer.parseInt(elements[2]);
                people = people.stream().filter(e -> e.length() != len)
                        .collect(Collectors.toList());
            } else if (command.equals("Contains")) {
                String str = elements[1];
                people = people.stream().filter(e -> !e.contains(str))
                        .collect(Collectors.toList());
            }
        }
        if (!people.isEmpty()) {
            for (String person : people) {
                System.out.print(person + " ");
            }

        }

    }
}
