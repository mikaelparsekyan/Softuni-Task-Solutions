import java.util.Scanner;

public class digitivison {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        double digitSum = a + b + c;

        boolean isDigitivisionPossible = false;

        int max = Math.max(Math.max(a, b), c);
        int num = 0;
        for (int i = max; i >= 0; i--) {
            for (int j = max; j >= 0; j--) {
                for (int k = max; k >= 0; k--) {
                    if ((((i == a && j == b && k == c) || (i == a && j == c && k == b) ||
                            (i == c && j == b && k == a) || (i == c && j == a && k == b) ||
                            (i == b && j == a && k == c) || (i == b && j == c && k == a)))) {
                        if (i != 0) {
                            num = Integer.parseInt(String.format("%d%d%d", i, j, k));
                            if (num % digitSum == 0) {
                                isDigitivisionPossible = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (isDigitivisionPossible) {
            System.out.println("Digitivision successful!");
            return;
        }
        System.out.println("No digitivision possible.");
    }
}
