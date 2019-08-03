import java.util.Scanner;

public class StringManipulator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String command = scanner.nextLine();
        while (!"Done".equals(command)) {
            String[] elements = command.split(" ");
            switch (elements[0]) {
                case "Change":
                    char replaceChar = elements[1].charAt(0);
                    char newChar = elements[2].charAt(0);
                    text = text.replace(replaceChar, newChar);
                    System.out.println(text);
                    break;
                case "Includes":
                    String stringToInclude = elements[1];
                    if (text.contains(stringToInclude)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endString = elements[1];
                    StringBuilder textToBuilder = new StringBuilder(text);
                    StringBuilder endStringToBuilder = new StringBuilder(endString);
                    textToBuilder = textToBuilder.reverse();
                    String val = textToBuilder.toString().substring(0,endString.length());
                    if(val.equals(endStringToBuilder.reverse().toString())){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    char ch = elements[1].charAt(0);
                    for (int i = 0; i < text.length(); i++) {
                        if (ch == text.charAt(i)) {
                            System.out.println(i);
                            break;
                        }
                    }
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(elements[1]);
                    int endIndex = Integer.parseInt(elements[2]) + startIndex;
                    StringBuilder newString = new StringBuilder();
                    StringBuilder removed = new StringBuilder();
                    for (int i = 0; i < text.length(); i++) {
                        if (i < startIndex || i >= endIndex) {
                            newString.append(text.charAt(i));
                        } else {
                            removed.append(text.charAt(i));
                        }
                    }
                    text = newString.toString();
                    System.out.println(removed.toString());
                    break;
            }

            command = scanner.nextLine();
        }
    }
}

