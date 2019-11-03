package first_and_reserve_team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        Team team = new Team("Black Eagles");
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            try {

                people.add(new Person(input[0], input[1],
                        Integer.parseInt(input[2]),
                        Double.parseDouble(input[3])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (Person person : people) {
            team.addPlayer(person);
        }
        System.out.println("First team have " +
                team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " +
                team.getReserveTeam().size() + " players");
    }
}
