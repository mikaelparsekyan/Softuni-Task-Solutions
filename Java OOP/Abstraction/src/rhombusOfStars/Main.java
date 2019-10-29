package rhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printRhombus(n);
    }
    private static void printRhombus(int n){
        //IF IT IS HARD TO READ, PROSTO ZAEBI...
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = n - i - 1; j >0 ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
