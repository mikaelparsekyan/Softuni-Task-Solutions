import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            switch (elements[0]){
                case 1:
                    stack.push(elements[1]);
                    break;
                case 2:
                    if(stack.size()>0) {
                        stack.pop();
                    }
                    break;
                case 3:
                    if(stack.size()>0) {
                        System.out.println(Collections.max(stack));
                    }
                    break;
            }
        }
    }

}
