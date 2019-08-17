import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stackOpen = new ArrayDeque<>();
        ArrayDeque<Character> stackClose = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '[' || currentChar == '(' || currentChar == '{') {
                stackOpen.push(currentChar);
            } else {
                stackClose.push(currentChar);
                removeFromStack(currentChar,stackOpen,stackClose);
            }
        }


        if (stackOpen.isEmpty() && stackClose.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void removeFromStack(char character,
                                ArrayDeque<Character> stackOpen, ArrayDeque<Character> stackClose) {
        char oppositeChar = ' ';
        if (character == ')') {
            oppositeChar = '(';
        } else if (character == '}') {
            oppositeChar = '{';
        } else if (character == ']') {
            oppositeChar = '[';
        }
        if (stackOpen.size() > 0) {
            if (stackOpen.peek() == oppositeChar) {
                stackOpen.pop();
                stackClose.pop();
            }
        }
    }
}
