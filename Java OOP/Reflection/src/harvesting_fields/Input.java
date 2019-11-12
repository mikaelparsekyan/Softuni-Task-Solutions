package harvesting_fields;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return this.scanner.nextLine();
    }
}
