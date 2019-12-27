import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class nexus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] arr2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int sumValue = 0;
        while (!input.equals("nexus")) {
            String[] connections = input.split("\\|");
            int[] firstConnection = Arrays.stream(connections[0].split(":"))
                    .mapToInt(Integer::parseInt).toArray();
            int[] secondConnection = Arrays.stream(connections[1].split(":"))
                    .mapToInt(Integer::parseInt).toArray();

            int f1 = firstConnection[0];
            int f2 = firstConnection[1];

            int s1 = secondConnection[0];
            int s2 = secondConnection[1];

            //sumValue = 0;
            if ((f1 != f2) || (s1 != s2)) {
                if (((f1 >= s1) && (f2 <= s2)) || (f1 <= s1) && (f2 >= s2)) {
                    //System.out.println("connection");
                    sumValue = arr1[f1] + arr1[s1] + arr2[f2] + arr2[s2];
                    arr1 = resizeArr(arr1, f1, s1);
                    arr2 = resizeArr(arr2, s2, f2);
                    addSum(arr1,sumValue);
                    addSum(arr2,sumValue);
                }
            }

            input = scanner.nextLine();
        }

        printArr(arr1);
        System.out.println();
        printArr(arr2);
    }

    private static void addSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += sum;
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
    }

    private static int[] resizeArr(int[] arr, int s, int e) {
        int[] result = new int[arr.length - (e - s) - 1];
        int resIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < s || i > e) {
                result[resIndex] = arr[i];
                resIndex++;
            }
        }
        return result;
    }
}
