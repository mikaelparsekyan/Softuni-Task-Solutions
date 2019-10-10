import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, HashSet<String>> peopleValues = new LinkedHashMap<>();
        while (!"JOKER".equals(input)) {
            String[] elements = input.split(": ");
            String personName = elements[0];
            HashSet<String> cards = Arrays.stream(elements[1].split(", "))
                    .collect(Collectors.toCollection(HashSet::new));
            int currentValue = 0;
//            for (int i = 0; i < cards.length; i++) {
//                String card = cards[i];
//                currentValue += calculateCardValue(card);
//            }
            if (peopleValues.containsKey(personName)) {
                cards = peopleValues.get(personName);
                peopleValues.put(personName, cards);
            } else {
                peopleValues.put(personName, cards);
            }
            input = scanner.nextLine();
        }
        peopleValues.entrySet().stream().forEach(e -> {
            int sum = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                sum += calculateCardValue(e.getValue().iterator().next());
            }
            System.out.printf("%s:%d%n", e.getKey(),sum);
        });
    }

    private static int calculateCardValue(String card) {
        char firstChar = card.charAt(0);
        char secondChar = card.charAt(1);
        int firstValue = 0;
        int secondValue = 0;
        switch (firstChar) {
            case 'J':
                firstValue = 11;
                break;
            case 'Q':
                firstValue = 12;
                break;
            case 'K':
                firstValue = 13;
                break;
            case 'A':
                firstValue = 14;
                break;
            default:
                firstValue = Integer.parseInt(String.valueOf(firstChar));
                break;
        }
        switch (secondChar) {
            case 'S':
                secondValue = 4;
                break;
            case 'H':
                secondValue = 3;
                break;
            case 'D':
                secondValue = 2;
                break;
            case 'C':
                secondValue = 1;
                break;
        }
        return firstValue * secondValue;
    }
}
