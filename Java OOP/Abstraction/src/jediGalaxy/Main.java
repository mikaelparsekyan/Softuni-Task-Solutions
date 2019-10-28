package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readInput(scanner.nextLine());

        int x = dimensions[0];
        int y = dimensions[1];

        Galaxy galaxy = new Galaxy(x, y);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoS = readInput(command);
            int[] evil = readInput(scanner.nextLine());

            int evilX = evil[0];
            int evilY = evil[1];

            galaxy.destroyCells(evilX, evilY);

            int playerX = ivoS[0];
            int playerY = ivoS[1];

            sum += galaxy.getPlayerSum(playerX, playerY);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
    private static int[] readInput(String input){
        return Arrays.stream(input
                .split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
