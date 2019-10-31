package cardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s:%n", scanner.nextLine());
        Ranks[] ranks = Ranks.values();
        for (Ranks rank : ranks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    rank.ordinal(), rank.toString());
        }
    }
}
