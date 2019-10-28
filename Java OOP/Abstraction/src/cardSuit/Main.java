package cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s:%n",scanner.nextLine());
        Cards[] cards = Cards.values();
        for (int i = 0; i < cards.length; i++) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    i,cards[i]);
        }
    }
}
