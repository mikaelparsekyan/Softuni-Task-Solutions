import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> people = new TreeSet<>();
        while (!"PARTY".equalsIgnoreCase(input)) {
            people.add(input);
            input = scanner.nextLine();
        }
        while (!"END".equalsIgnoreCase(input)) {
            people.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(people.size());
        for (String person : people) {
            System.out.println(person);
        }


    }
}
