import java.util.*;

public class ExtractPersonInformation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.substring(input.indexOf("@") + 1, input.indexOf("|"));
            int age = Integer.parseInt(input.substring(
                    input.indexOf("#") + 1, input.indexOf("*")
            ));
            System.out.printf("%s is %d years old.\n", name, age);
        }
    }
}

