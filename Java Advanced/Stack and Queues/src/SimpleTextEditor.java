import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operations = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < operations; i++) {
            String[] elements = scanner.nextLine().split(" ");
            switch (elements[0]) {
                case "1":
                    text.append(elements[1]);
                    stack.push(text.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(elements[1]);
                    if(count<= text.toString().length()) {
                        text = new StringBuilder(text.substring(0, text.length() - count));
                    }
                    stack.push(text.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(elements[1]);
                    if (index > 0 && index <= text.length()) {
                        System.out.println(text.charAt(index-1));
                    }
                    break;
                case "4":
                    //if(!stack.isEmpty()) {
                    assert stack.peek() != null;
                    if (stack.peek().contentEquals(text)) {
                        stack.pop();
                    }
                    //}
                    if(!stack.isEmpty()){
                        text = new StringBuilder(stack.pop());
                    }
                    break;
            }
        }
    }
}
