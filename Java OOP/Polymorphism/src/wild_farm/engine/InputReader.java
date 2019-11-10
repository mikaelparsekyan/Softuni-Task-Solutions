package wild_farm.engine;

import java.util.Scanner;

public class InputReader {
    private Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String[] readLineAsArray(String split) {
        return this.scanner.nextLine().split(split);
    }
}
