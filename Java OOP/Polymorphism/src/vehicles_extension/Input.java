package vehicles_extension;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String[] readLineAsArray(){
        return this.scanner.nextLine().split("\\s+");
    }

    public int readNextNumber(){
        return Integer.parseInt(this.scanner.nextLine());
    }
}
