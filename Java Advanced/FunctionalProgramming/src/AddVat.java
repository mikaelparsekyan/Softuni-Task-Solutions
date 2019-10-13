import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> addVat = e -> e + (e * 0.20);
        List<Double> prices = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Prices with VAT:");
        for (Double price : prices) {
            System.out.printf("%.2f%n", addVat.apply(price));
        }

    }
}
