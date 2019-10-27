package stackIterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackIterator<Integer> stack = new StackIterator<>();
//        stack.push(-1);
//        stack.push(-12);
//        stack.push(-2343);
        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] elements = command.split("\\s+");
            switch (elements[0]) {
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Push":
                    int[] vals = Arrays.stream(command.substring(5)
                            .split(", | "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    for (int i : vals) {
                        stack.push(i);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer e : stack) {
                System.out.println(e);
            }
        }

    }
}
