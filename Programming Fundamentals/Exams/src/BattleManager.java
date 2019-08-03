import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> peopleMapHealth = new HashMap<>();
        Map<String, Integer> peopleMapEnergy = new HashMap<>();
        while (!"Results".equals(input)) {
            String[] elements = input.split(":");
            switch (elements[0]) {
                case "Add":
                    String name = elements[1];
                    int health = Integer.parseInt(elements[2]);
                    int energy = Integer.parseInt(elements[3]);
                    if (peopleMapHealth.containsKey(name) && peopleMapEnergy.containsKey(name)) {
                        peopleMapHealth.put(name, peopleMapHealth.get(name) + health);
                    } else {
                        peopleMapHealth.put(name,health);
                        peopleMapEnergy.put(name,energy);
                    }
                    break;
                case "Attack":
                    String attackerName = elements[1];
                    String defenderName = elements[2];
                    int damage = Integer.parseInt(elements[3]);
                    if (peopleMapHealth.containsKey(defenderName) && peopleMapEnergy.containsKey(attackerName)) {
                        int currentDefenderHealth = peopleMapHealth.get(defenderName);
                        int currentAttackerEnergy = peopleMapEnergy.get(attackerName);
                        if (currentDefenderHealth - damage <= 0) {
                            System.out.println(defenderName + " was disqualified!");
                            peopleMapHealth.remove(defenderName);
                            peopleMapEnergy.remove(defenderName);
                        } else {
                            //currentDefender.setHealth(currentDefender.getHealth() - damage);
                            peopleMapHealth.put(defenderName,peopleMapHealth.get(defenderName)-damage);
                        }
                        if (currentAttackerEnergy - 1 <= 0) {
                            System.out.println(attackerName + " was disqualified!");
                            peopleMapHealth.remove(attackerName);
                            peopleMapEnergy.remove(attackerName);
                        } else {
                            //currentDefender.setHealth(currentDefender.getHealth() - damage);
                            peopleMapEnergy.put(attackerName,peopleMapEnergy.get(attackerName)-1);
                        }
                    }
                    break;
                case "Delete":
                    String userToRemove = elements[1];
                    if (userToRemove.equals("All")) {
                        peopleMapEnergy = new HashMap<>();
                        peopleMapHealth = new HashMap<>();

                    } else {
                        peopleMapEnergy.remove(userToRemove);
                        peopleMapHealth.remove(userToRemove);


                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("People count: " + peopleMapHealth.size());
        Map<String, Integer> finalPeopleMapEnergy = peopleMapEnergy;
        peopleMapHealth.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if(result==0){
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(a -> {
            System.out.printf("%s - %s - %s\n", a.getKey(), a.getValue(), finalPeopleMapEnergy.get(a.getKey()));
        });
    }
}
