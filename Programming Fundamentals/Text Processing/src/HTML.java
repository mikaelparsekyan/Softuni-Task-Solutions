import java.util.*;

public class HTML {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        printTitle(title);
        String content = scanner.nextLine();
        printContent(content);
        String comment = scanner.nextLine();
        while (!"end of comments".equals(comment)) {
            printComment(comment);
            comment = scanner.nextLine();
        }
    }

    private static void printContent(String content) {
        System.out.println("<article>");
        System.out.println(content);
        System.out.println("</article>");
    }
    private static void printComment(String comment) {
        System.out.println("<div>");
        System.out.println(comment);
        System.out.println("</div>");
    }

    private static void printTitle(String title) {
        System.out.println("<h1>");
        System.out.println(title);
        System.out.println("</h1>");
    }
}


