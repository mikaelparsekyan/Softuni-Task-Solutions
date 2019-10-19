package generic_swap_method_integers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
            box.addValue(Integer.valueOf(scanner.nextLine()));
        }
        int swapElementIndex = scanner.nextInt();
        int swapElementToIndex = scanner.nextInt();
        box.swap(swapElementIndex,swapElementToIndex);
        for (Integer value : box.getData()) {
            System.out.println(value.getClass().getCanonicalName() + ": " + value);
        }

    }
}
