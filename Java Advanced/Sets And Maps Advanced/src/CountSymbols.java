import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> characters = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (characters.containsKey(currentChar)) {
                characters.put(currentChar,
                        characters.get(currentChar) + 1);
            } else {
                characters.put(currentChar, 1);
            }
        }
        for (var entry : characters.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(),
                    entry.getValue());
        }

    }
}
