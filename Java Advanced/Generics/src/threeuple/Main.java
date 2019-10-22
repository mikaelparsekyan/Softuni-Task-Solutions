package threeuple;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split("\\s+");
        String[] line2 = scanner.nextLine().split("\\s+");
        String[] line3 = scanner.nextLine().split("\\s+");
        List<Threeuple> result = new LinkedList<>();

        result.add(new Threeuple<>(line1[0] + " " + line1[1], line1[2], line1[3]));
        if (line2[2].equals("drunk")) {
            line2[2] = "true";
        } else {
            line2[2] = "false";
        }
        result.add(new Threeuple<>(line2[0],
                Integer.parseInt(line2[1]), line2[2]));
        result.add(new Threeuple<>(line3[0],
                Double.parseDouble(line3[1]), line3[2]));

        print(result);
    }

    private static void print(List<Threeuple> threeuples) {
        StringBuilder sb = new StringBuilder();
        for (Threeuple threeuple : threeuples) {
            sb.append(threeuple).append("\n");
        }
        System.out.print(sb.toString());
    }
}
