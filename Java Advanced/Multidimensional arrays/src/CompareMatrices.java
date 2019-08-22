import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix1 = new int[arr1[0]][arr1[1]];
        for (int i = 0; i < arr1[0]; i++) {
            matrix1[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[] arr2 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix2 = new int[arr2[0]][arr2[1]];
        for (int i = 0; i < arr2[0]; i++) {
            matrix2[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        if (isEqual(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean isEqual(int[][] arr1, int[][] arr2) {
        if(arr1.length!=arr2.length){
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i].length!=arr2[i].length){
                    return false;
                } else {
                    for (int j = 0; j < arr1[i].length; j++) {
                        if(arr1[i][j] != arr2[i][j]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
