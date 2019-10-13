import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            people.add(new Person(elements[0], Integer.parseInt(elements[1])));
        }
        people.stream()
                .filter(e -> e.age > 30)
                .sorted(Comparator.comparing(a -> a.name))
                .forEach(e -> {
                    System.out.printf("%s - %d%n", e.name, e.age);
                });
    }
}

