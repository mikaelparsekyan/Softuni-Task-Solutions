import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+[^\\W0-9])([^\\@\\-\\>\\!\\:]+)!(?<beh>[GN])!");
        List<String> people = new ArrayList<>();
        while (!"end".equals(input)) {
            input = decrypt(input, key);
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String behaviour = matcher.group("beh");
                if(behaviour.equals("G")){
                    people.add(matcher.group("name"));
                }
            }

            input = scanner.nextLine();
        }
        for (String person : people) {
            System.out.println(person);
        }

    }

    private static String decrypt(String input, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result.append((char) (input.charAt(i) - key));
        }

        return result.toString();
    }
}
