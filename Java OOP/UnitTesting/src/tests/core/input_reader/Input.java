package tests.core.input_reader;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getNextLine(String split) {
        return this.scanner.nextLine().split(split);
    }
}
