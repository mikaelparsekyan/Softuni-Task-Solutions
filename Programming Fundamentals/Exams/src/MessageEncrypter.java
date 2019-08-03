import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            System.out.println(decryptMessage(input));
        }
    }
    static String decryptMessage(String message){
        Matcher matcher = Pattern.compile(
                "([@|*])(?<tag>[A-Z][a-z]{2,})\\1: (\\[(?<letter1>[A-Za-z])\\]\\|)(\\[(?<letter2>[A-Za-z])\\]\\|)(\\[(?<letter3>[A-Za-z])\\]\\|)$")
                .matcher(message);
        if(!matcher.find()){
            return "Valid message not found!";
        } else {
            String result = "";
            String tag = matcher.group("tag");
            int l1 = (int)(matcher.group("letter1").charAt(0));
            int l2 = (int)(matcher.group("letter2").charAt(0));
            int l3 = (int)(matcher.group("letter3").charAt(0));
            result = String.format("%s: %d %d %d",tag,l1,l2,l3);
            return result;
        }
    }
}

