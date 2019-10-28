package cardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s:%n",scanner.nextLine());
        Ranks[] ranks = Ranks.values();
        for (int i = 0; i < ranks.length; i++) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    i,ranks[i]);
        }
    }
}
