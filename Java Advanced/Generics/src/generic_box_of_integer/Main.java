package generic_box_of_integer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.valueOf(scanner.nextLine());
            Box<Integer> box = new Box<>(val);
            System.out.println(box.toString());
        }
    }
}
