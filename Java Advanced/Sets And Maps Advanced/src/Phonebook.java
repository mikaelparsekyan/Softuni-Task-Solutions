import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> peopleNumbers = new HashMap<>();
        String input = scanner.nextLine();
        while (!"search".equals(input)) {
            String[] elements = input.split("-");
            peopleNumbers.put(elements[0],elements[1]);
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!"stop".equals(name)){
            if(peopleNumbers.containsKey(name)){
                System.out.printf("%s -> %s%n",
                        name,peopleNumbers.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n",name);
            }

            name = scanner.nextLine();
        }
    }
}
