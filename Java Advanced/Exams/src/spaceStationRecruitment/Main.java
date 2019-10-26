package spaceStationRecruitment;

public class Main {
    public static void main(String[] args) {
        SpaceStation spaceStation = new SpaceStation("Apolo", 10);

        Astronaut astronaut =
                new Astronaut("Stephen", 40, "Bulgaria");

        System.out.println(astronaut); // Astronaut: Stephen, 40 (Bulgaria)
        spaceStation.add(astronaut);

        spaceStation.remove("Astronaut name"); // false

        Astronaut secondAstronaut = new Astronaut("Mark", 34, "UK");
        Astronaut thirdAstronaut = new Astronaut("kiro", 3, "bg");
        Astronaut fourthAstronaut = new Astronaut("Marky mark", 34423, "K");

        spaceStation.add(secondAstronaut);
        spaceStation.add(thirdAstronaut);
        spaceStation.add(fourthAstronaut);

        Astronaut oldestAstronaut = spaceStation.getOldestAstronaut();

        Astronaut astronautStephen = spaceStation.getAstronaut("Stephen");
        System.out.println(oldestAstronaut); // Astronaut: Stephen, 40 (Bulgaria)
        System.out.println(astronautStephen); // Astronaut: Stephen, 40 (Bulgaria)

        System.out.println(spaceStation.getCount()); // 2
        System.out.println(spaceStation.report());

    }
}
