package generic_swap_method_strings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            box.addValue(scanner.nextLine());
        }
        int swapElementIndex = scanner.nextInt();
        int swapElementToIndex = scanner.nextInt();
        box.swap(swapElementIndex,swapElementToIndex);
        for (String value : box.getData()) {
            System.out.println(value.getClass().getCanonicalName() + ": " + value);
        }

    }
}
