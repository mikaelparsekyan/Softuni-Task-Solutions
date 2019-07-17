import java.util.*;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Character> alphabet = new HashMap<>();
        String[] letters = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        String[] input = scanner.nextLine().split("\\s+");
        StringBuilder result = new StringBuilder();
        int start = 65;
        for (int i = 0; i < letters.length; i++) {
            alphabet.put(letters[i], (char) (start));
            start++;
        }
        for (int i = 0; i < input.length; i++) {
            String currentValue = input[i];
            if(currentValue.equals("|")){
                result.append(" ");
            }
            if(alphabet.containsKey(currentValue)){
                result.append(alphabet.get(currentValue));
            }
        }
        System.out.println(result);
    }

}
