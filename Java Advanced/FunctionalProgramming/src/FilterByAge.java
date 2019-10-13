import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Consumer<Map<String, Integer>> print = e -> {
            e.entrySet().forEach(val -> {
                System.out.printf("%s - %d%n", val.getKey(), val.getValue());
            });
        };
        Map<String, Integer> peopleAge = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(", ");
            peopleAge.put(elements[0], Integer.valueOf(elements[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split("\\s+");

        if (condition.equals("younger")) {
            peopleAge = peopleAge.entrySet().stream()
                    .filter(e -> e.getValue() <= age)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (a,b)->a,LinkedHashMap::new));
        } else if (condition.equals("older")) {
            peopleAge = peopleAge.entrySet().stream()
                    .filter(e -> e.getValue() >= age)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (a,b)->a,LinkedHashMap::new));
        }
        if (format.length == 2) {
            print.accept(peopleAge);
        } else {
            if(format[0].equals("name")){
                peopleAge.entrySet().stream().forEach(e->{
                    System.out.println(e.getKey());
                });
            } else {
                peopleAge.entrySet().stream().forEach(e->{
                    System.out.println(e.getValue());
                });
            }
        }
    }
}
