import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();      //"(([^\d]+)(\d+))
        Pattern pattern = Pattern.compile("(?<sequence>[^\\d]+)(?<digit>\\d+)");
        Matcher matcher = pattern.matcher(input);
        List<String> uniqueSymbols = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String sequence = matcher.group("sequence");
            int n = Integer.parseInt(matcher.group("digit"));
            StringBuilder currentSequence = new StringBuilder();
            for (int i = 0; i < n; i++) {
                currentSequence.append(sequence.toUpperCase());
            }
            for (int i = 0; i < currentSequence.length(); i++) {
                if(!uniqueSymbols.contains(currentSequence.charAt(i)+"")){
                    uniqueSymbols.add(currentSequence.charAt(i)+"");
                }
            }

            result.append(currentSequence.toString());
        }
        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(result);
    }
}
