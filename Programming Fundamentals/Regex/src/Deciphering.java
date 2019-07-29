import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] substrings = scanner.nextLine().split(" ");

        Matcher matcher = Pattern.compile("^([d-z\\{\\}\\|\\#]+)$").matcher(text);
        if(matcher.find()){
            text = decrypt(text);
            text = text.replace(substrings[0],substrings[1]);
        } else {
            text = "This is not the book you are looking for.";
        }
        System.out.println(text);
    }

    private static String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            decryptedText.append((char) (text.charAt(i) - 3));
        }
        return decryptedText.toString();
    }
}
