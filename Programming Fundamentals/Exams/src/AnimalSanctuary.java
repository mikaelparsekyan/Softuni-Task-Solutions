import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int totalSum = 0;
        Pattern pattern = Pattern.compile("^n:(?<name>[^;]+);t:(?<kind>[^;]+);c--(?<country>[A-Za-z ]+)");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int animalWeight = 0;
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                if (Character.isDigit(currentChar)) {
                    animalWeight += Integer.parseInt(currentChar + "");
                }
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                name = editString(name);
                String kind = matcher.group("kind");
                kind = editString(kind);
                String country = matcher.group("country");
                country = editString(country);
                System.out.printf("%s is a %s from %s\n", name, kind, country);
                totalSum += animalWeight;
            }
        }
        System.out.printf("Total weight of animals: %dKG", totalSum);
    }

    static String editString(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar) || currentChar == ' ') {
                sb.append(currentChar + "");
            }
        }
        return sb.toString();
    }
}


