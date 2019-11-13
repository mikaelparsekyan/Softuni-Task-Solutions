package word;

import word.interfaces.CommandInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        CommandInterface commandInterface = Initialization.generateCommandInterface(text);

        String input = scanner.nextLine();
        while (!"exit".equals(input)) {
            commandInterface.readInput(input);
            input = scanner.nextLine();
        }
        System.out.println(commandInterface.getText());
    }
}
