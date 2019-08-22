import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[arr[0]][arr[1]];
        for (int i = 0; i < arr[0]; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int numberToFind = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if(row[j]==numberToFind){
                    isFound = true;
                    System.out.printf("%d %d\n",i,j);
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }
}
