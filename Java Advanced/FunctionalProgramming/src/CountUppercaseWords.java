import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> filterCapitalLetter = e ->
                Character.isUpperCase(e.charAt(0));
        List<String> uppercaseWords = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .filter(filterCapitalLetter)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(uppercaseWords.size());
        for (String word : uppercaseWords) {
            System.out.println(word);
        }


    }
}
