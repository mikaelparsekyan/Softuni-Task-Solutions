package cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s:%n", scanner.nextLine());
        Cards[] cards = Cards.values();
        for (Cards card : cards) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    card.ordinal(), card.toString());
        }
    }
}
