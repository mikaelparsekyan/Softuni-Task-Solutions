import java.util.*;

public class AsciiSumator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar > start && currentChar < end) {
                sum += (int) currentChar;
            }
        }
        System.out.println(sum);
    }
}


