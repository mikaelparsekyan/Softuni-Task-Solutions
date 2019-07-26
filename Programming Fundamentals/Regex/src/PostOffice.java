
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");

        String firstPart = input[0];
        String firstRegex = "([#$%*&])(?<firstPart>[A-Z]+)\\1";
        Pattern pattern1 = Pattern.compile(firstRegex);
        Matcher matcher1 = pattern1.matcher(firstPart);

        String capitalLetters = "";
        if (matcher1.find()) {
            capitalLetters = matcher1.group("firstPart");
        }

        String secondPart = input[1];
        String thirdPart = input[2];
        String[] tokens = thirdPart.split("\\s+");

        String secondRegex = "(?<asciiCode>[6-9][5-9]|[7-9][0-9]):(?<length>[0-1][1-9]|[2][0])(?![0-9])";
        Pattern pattern2 = Pattern.compile(secondRegex);

        for (int i = 0; i < capitalLetters.length(); i++) {
            char symbol = capitalLetters.charAt(i);
            Matcher matcher2 = pattern2.matcher(secondPart);
            while (matcher2.find()) {
                int asciiCode = Integer.parseInt(matcher2.group("asciiCode"));
                int length = Integer.parseInt(matcher2.group("length")) + 1;
                if (symbol == (char) asciiCode) {
                    for (String token : tokens) {
                        if (token.charAt(0) == symbol && token.length() == length) {
                            System.out.println(token);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}