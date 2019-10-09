import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();

        firstPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        secondPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        int iterations = 50;

        while (iterations-- > 0) {

            int firstValue = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstValue);
            int secondValue = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondValue);

            if (firstValue > secondValue) {
                firstPlayerDeck.add(firstValue);
                firstPlayerDeck.add(secondValue);
            } else if (secondValue > firstValue) {
                secondPlayerDeck.add(firstValue);
                secondPlayerDeck.add(secondValue);
            } else {
                firstPlayerDeck.add(firstValue);
                secondPlayerDeck.add(secondValue);
            }
            if (firstPlayerDeck.size() == 0 || secondPlayerDeck.size() == 0) {
                break;
            }
        }
        if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else if(firstPlayerDeck.size() > secondPlayerDeck.size()){
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
