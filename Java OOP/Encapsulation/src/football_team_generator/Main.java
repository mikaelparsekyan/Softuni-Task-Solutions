package football_team_generator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teams = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] elements = command.split(";");
            try {
                switch (elements[0]) {
                    case "Team":
                        teams.put(elements[1], new Team(elements[1]));
                        break;
                    case "Add":
                        Team teamToAdd = teams.get(elements[1]);
                        if (teamToAdd != null) {
                            Player player = new Player(
                                    elements[2],
                                    Integer.parseInt(elements[3]),
                                    Integer.parseInt(elements[4]),
                                    Integer.parseInt(elements[5]),
                                    Integer.parseInt(elements[6]),
                                    Integer.parseInt(elements[7]));
                            teamToAdd.addPlayer(player);
                        } else {
                            System.out.printf("Team %s does not exist.%n", elements[1]);
                        }
                        break;
                    case "Remove":
                        Team team = teams.get(elements[1]);
                        if (team != null) {
                            team.removePlayer(elements[2]);
                        } else {
                            System.out.printf("Team %s does not exist.%n",elements[1]);
                        }
                        break;
                    case "Rating":
                        Team currentTeam = teams.get(elements[1]);
                        if (currentTeam != null) {
                            System.out.println(currentTeam);
                        } else {
                            System.out.printf("Team %s does not exist.%n",elements[1]);
                        }
                        break;

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
    }
}
