import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?<name>[A-Za-z0-9\\!\\@\\#\\$\\?]+)=(?<length>[0-9]+)<<(?<code>.*)$");
        boolean isFound = false;
        while (!"Last note".equals(input)){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String code = matcher.group("code");
                if (length == code.length()) {
                    name = getName(name);
                    System.out.printf("Coordinates found! %s -> %s%n", name, code);
                    isFound = true;
                } else {
                    isFound = false;
                }
            } else {
                isFound = false;
            }
            if(!isFound){
                System.out.println("Nothing found!");
            }
            input = scanner.nextLine();
        }
    }
    private static String getName(String name){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            if(Character.isLetterOrDigit(name.charAt(i))){
                result.append(name.charAt(i));
            }
        }
        return result.toString();
    }
}
