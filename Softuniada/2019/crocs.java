import java.util.Scanner;

public class crocs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int width = n * 5;

        int headerReps = (n - 1) / 2;
        int footerReps = (n - 1) / 2;
        if (headerReps == 0) {
            headerReps = 1;
        }
        if (footerReps == 0) {
            footerReps = 1;
        }
        printHeader(n, width, headerReps);

        printBody(n, width);

        for (int i = 0; i < (n + 1)/2; i++) {
            printFullLine(n, width);
            printSplitLine(n, width);
        }
        printFooter(n, width, footerReps);
    }

    private static void printHeader(int n, int width, int headerReps) {
        for (int k = 0; k < headerReps; k++) {
            printSpace(n);
            printSign(width - (2 * n));
            printSpace(n);
            System.out.println();
        }
    }

    private static void printBody(int n, int width) {
        printLine(n, width);
        for (int k = 0; k < n * 2 - 1; k++) {
            printSign(n);
            System.out.print(" ");
            if (k % 2 == 0) {
                for (int i = 0; i < width - (2 * n) - 2; i++) {
                    if (i % 2 == 0) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int i = 0; i < width - (2 * n) - 2; i++) {
                    if (i % 2 == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("#");
                    }
                }
            }
            System.out.print(" ");
            printSign(n);
            System.out.println();
        }
        printLine(n, width);
    }

    private static void printLine(int n, int width) {
        printSign(n);
        printSpace(width - (2 * n));
        printSign(n);
        System.out.println();
    }

    private static void printFullLine(int n, int width) {
        printSign(width);
        System.out.println();
    }

    private static void printSplitLine(int n, int width) {
        printSign(n);
        for (int i = 0; i < width - (2 * n); i++) {
            if (i % 2 == 0) {
                System.out.print(" ");
            } else {
                System.out.print("#");
            }
        }
        printSign(n);
        System.out.println();
    }

    private static void printFooter(int n, int width, int footerReps) {
        printFullLine(n,width);
        for (int k = 0; k < footerReps; k++) {
            printSpace(n);
            for (int i = 0; i < width - (2 * n); i++) {
                System.out.print("#");
            }
            printSpace(n);
            System.out.println();
        }
    }
    private static void printSign(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
    }
    private static void printSpace(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }
}
