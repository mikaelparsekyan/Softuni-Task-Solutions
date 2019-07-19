import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "^>+(?<type>[A-Z{0,}a-z]+)+<<(?<price>\\d+\\.?\\d+)+!(?<quantity>[\\d+]+)\\b";
        double totalSum = 0;
        System.out.println("Bought furniture:");
        while (!"Purchase".equals(input)){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()) {
                System.out.println(matcher.group("type"));
                double price = Double.parseDouble(matcher.group("price"));
                double quantity = Double.parseDouble(matcher.group("quantity"));
                totalSum += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f",totalSum);
    }
}
