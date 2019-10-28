package studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String line = scanner.nextLine();
        while (!"Exit".equals(line)) {
            String[] input = line.split(" ");
            studentSystem.ParseCommand(input);
            line = scanner.nextLine();
        }
    }
}
