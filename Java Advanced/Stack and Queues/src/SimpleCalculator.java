import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(expression.split("\\s+")).forEach(stack::addLast);
        while (stack.size() > 1) {
            Integer firstNumber = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            Integer secondNumber = Integer.parseInt(stack.pop());
            if (operation.equals("+")) {
                stack.push(String.valueOf(firstNumber + secondNumber));
            } else if (operation.equals("-")) {
                stack.push(String.valueOf(firstNumber - secondNumber));
            }
        }
        System.out.println(stack.peek());
    }
}
