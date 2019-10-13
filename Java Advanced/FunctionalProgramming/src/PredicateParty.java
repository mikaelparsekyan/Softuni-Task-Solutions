import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> filters = new ArrayList<>();
        List<String> people = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"Party!".equals(input)) {
            String[] elements = input.split("\\s+");
            String commandType = elements[0];
            if ("Remove".equals(commandType)) {
                people.removeIf(filter(elements[1],elements[2]));
            } else if ("Double".equals(commandType)) {
                for (int i = 0; i < people.size(); i++) {
                    String person = people.get(i);
                    if(filter(elements[1],elements[2]).test(person)){
                        people.add(i++,person);
                    }
                }
            }
            input = scanner.nextLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            System.out.println(String.join(", ", people) +
                    " are going to the party!");
        }
    }

    private static Predicate<String> filter(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(parameter);
            case "EndsWith":
                return text -> text.endsWith(parameter);
            case "Length":
                return text -> text.length() == Integer.parseInt(parameter);
            default:
                return text -> false;
        }
    }
}
