package hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        String discountType = input[3];

        PriceCalculator calculator = new PriceCalculator(pricePerDay, days,
                season, discountType);

        System.out.printf("%.2f",calculator.getTotalPrice());
    }
}
