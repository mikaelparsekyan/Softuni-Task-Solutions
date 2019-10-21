package tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tuple<String, String> tuple1;
        Tuple<String, Integer> tuple2;
        Tuple<Integer, Double> tuple3;

        String[] line1 = scanner.nextLine().split("\\s+");
        tuple1 = new Tuple<>(line1[0] + " " + line1[1],line1[2]);

        String[] line2 = scanner.nextLine().split("\\s+");
        tuple2 = new Tuple<>(line2[0],Integer.parseInt(line2[1]));

        String[] line3 = scanner.nextLine().split("\\s+");
        tuple3 = new Tuple<>(Integer.parseInt(line3[0]),Double.parseDouble(line3[1]));

        System.out.println(tuple1.toString());
        System.out.println(tuple2.toString());
        System.out.println(tuple3.toString());
    }
}
