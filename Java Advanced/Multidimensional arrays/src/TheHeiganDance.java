import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] playerPosition = new int[]{7, 7};

        double playerHealth = 18500;
        double heiganHealth = 3000000;
        double playerDamage = Double.parseDouble(scanner.nextLine());

        boolean isCloudValid = false;
        String lastSpell = "";

        String input = scanner.nextLine();
        while (playerHealth > 0) {
            heiganHealth -= playerDamage;

            if (isCloudValid) {
                isCloudValid = false;
                playerHealth -= 3500;
            }
            if (playerHealth <= 0) {
                lastSpell = "Cloud";
                break;
            }
            if (heiganHealth <= 0) {
                break;
            }

            String[] elements = input.split("\\s+");
            String spell = elements[0];
            int spellRow = Integer.parseInt(elements[1]);
            int spellCol = Integer.parseInt(elements[2]);
            double currentDamage = 0;
            boolean isPlayerHit = isHit(playerPosition[0], playerPosition[1], spellRow, spellCol);
            if (isPlayerHit) {
                if ("Cloud".equals(spell)) {
                    currentDamage = 3500;
                } else if ("Eruption".equals(spell)) {
                    currentDamage = 6000;
                }
                boolean canMove = movePlayer(playerPosition, spellRow, spellCol);
                if (!canMove) {
                    playerHealth -= currentDamage;
                    if ("Cloud".equals(spell)) {
                        isCloudValid = true;
                    }
                    if (playerHealth <= 0) {
                        lastSpell = spell;
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        printResult(heiganHealth, playerHealth, lastSpell, playerPosition);
    }

    private static void printResult(double heiganHealth, double playerHealth,
                                    String lastSpell, int[] playerPosition) {
        if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);

        }
        if (playerHealth <= 0) {
            if (lastSpell.equals("Cloud")) {
                System.out.printf("Player: Killed by Plague %s%n", lastSpell);
            } else {
                System.out.printf("Player: Killed by %s%n", lastSpell);
            }
        } else {
            System.out.printf("Player: %.0f%n", playerHealth);
        }
        System.out.printf("Final position: %d, %d",
                playerPosition[0], playerPosition[1]);
    }

    private static boolean movePlayer(int[] playerPosition, int spellRow, int spellCol) {
        boolean canMove = true;
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        if (playerRow == spellRow && playerCol == spellCol) {
            canMove = false;
        } else if (isPlayerInMatrix(playerRow - 1, playerCol)
                && !isHit(playerRow - 1, playerCol, spellRow, spellCol)) {
            playerRow--;
        } else if (isPlayerInMatrix(playerRow + 1, playerCol)
                && !isHit(playerRow + 1, playerCol, spellRow, spellCol)) {
            playerRow++;
        } else if (isPlayerInMatrix(playerRow, playerCol - 1)
                && !isHit(playerRow, playerCol - 1, spellRow, spellCol)) {
            playerCol--;
        } else if (isPlayerInMatrix(playerRow, playerCol + 1)
                && !isHit(playerRow, playerCol + 1, spellRow, spellCol)) {
            playerCol++;
        } else {
            canMove = false;
        }
        playerPosition[0] = playerRow;
        playerPosition[1] = playerCol;

        return canMove;
    }

    private static boolean isPlayerInMatrix(int playerRow, int playerCol) {
        return playerRow >= 0 && playerRow < 15
                && playerCol >= 0 && playerCol < 15;
    }

    private static boolean isHit(int playerRow, int playerCol, int spellRow, int spellCol) {
        return playerRow >= spellRow - 1 && playerRow <= spellRow + 1
                && playerCol >= spellCol - 1 && playerCol <= spellCol + 1;
    }

}
