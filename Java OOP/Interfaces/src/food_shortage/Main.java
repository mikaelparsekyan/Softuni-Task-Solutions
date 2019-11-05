package food_shortage;

import food_shortage.Citizen;
import food_shortage.interfaces.Person;
import food_shortage.interfaces.Buyer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Buyer> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personValues = scanner.nextLine().split("\\s+");
            if (personValues.length == 4) {
                people.add(new Citizen(personValues[0], Integer.parseInt(personValues[1]),
                        personValues[2], personValues[3]));
            } else if (personValues.length == 3) {
                people.add(new Rebel(personValues[0], Integer.parseInt(personValues[1]),
                        personValues[2]));
            }
        }
        String personName = scanner.nextLine();
        while (!"End".equals(personName)) {
            for (Buyer b : people) {
                if(b.getName().equals(personName)){
                    b.buyFood();
                }
            }
            personName = scanner.nextLine();
        }
        System.out.println(people.stream().mapToInt(Buyer::getFood).sum());
    }
}
