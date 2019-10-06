import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> peopleEmails = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!"stop".equals(name)) {
            String email = scanner.nextLine();
            peopleEmails.put(name, email);
            name = scanner.nextLine();
        }
        Pattern pattern = Pattern.compile("^((?!\\.uk|us|com).)*$");
        peopleEmails.entrySet().stream().filter(e -> {
            return pattern.matcher(e.getValue()).find();
        }).forEach(e -> {
            System.out.printf("%s -> %s%n", e.getKey(), e.getValue());
        });
    }
}
