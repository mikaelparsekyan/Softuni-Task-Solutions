import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^([#$%*&])(?<name>[A-za-z]+)\\1=(?<length>[0-9]+)!!(?<coordinates>.+)$");
        boolean isFound = false;
        while (!isFound){
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            boolean isValid = true;
            if(matcher.find()) {
                int length = Integer.parseInt(matcher.group("length"));
                String coordinates = matcher.group("coordinates");
                if (length==coordinates.length()){
                    System.out.printf("Coordinates found! %s -> %s",matcher.group("name"),encryptCoordinates(coordinates));
                    isFound = true;
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
            if(!isValid){
                System.out.println("Nothing found!");
            }

        }
    }
    private static String encryptCoordinates(String coordinates){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < coordinates.length(); i++) {
            result.append((char)(coordinates.charAt(i)+coordinates.length()));
        }
        return result.toString();
    }
}
