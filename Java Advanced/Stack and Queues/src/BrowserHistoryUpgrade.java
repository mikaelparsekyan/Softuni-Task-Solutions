import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> currentUrl = new ArrayDeque<>();
        ArrayDeque<String> nextUrl = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!"Home".equals(input)) {

            if (input.equals("forward")) {
                if(nextUrl.size() > 0) {
                    String element = nextUrl.peek();
                    currentUrl.push(element);
                    System.out.println(element);
                    //nextUrl.clear();
                } else {
                    System.out.println("no next URLs");
                }
            } else if (input.equals("back")) {
                if (currentUrl.size() > 1) {
                    nextUrl.addFirst(currentUrl.pop());
                    String backUrl = currentUrl.peek();
                    System.out.println(backUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                //nextUrl.clear();
                System.out.println(input);
                if(nextUrl.size()>0){
                    while (!nextUrl.isEmpty()){
                        currentUrl.push(nextUrl.pop());
                    }
                }
                //nextUrl.clear();
                currentUrl.push(input);
            }


            input = scanner.nextLine();
        }
        System.out.println();
    }
}
