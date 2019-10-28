package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();
        Card card = new Card(rank,suit);
        System.out.printf("Card name: %s of %s; Card power: %d",
                rank,suit,card.getPower());
    }
}
