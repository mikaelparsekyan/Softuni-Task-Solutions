import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        String[] expression = bufferedReader.readLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String operator = "";
        for (int i = 0; i < expression.length; i++) {
            String currentVal = expression[i];
            boolean isNumber = false;
            try {
                int val = Integer.parseInt(currentVal);
                if (i == 0) {
                    queue.offer(val + "");
                    //stack.push(operator);
                } else {
                    queue.offer(val + "");
                    queue.offer(operator);
                }
                isNumber = true;

            } catch (NumberFormatException e) {
                if (!currentVal.equals(")") && !currentVal.equals("(")) {
                    operator = currentVal;
                } else {

                }
            }

        }
        for (String i : queue) {
            System.out.print(i + " ");
        }

    }
}
