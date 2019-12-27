import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class triforce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int perimeter = Integer.parseInt(scanner.nextLine());
        double radius = Double.parseDouble(scanner.nextLine());

        int maxSide = (int) (radius * 2);

        List<Integer> nums = new ArrayList<>();
        nums.add(maxSide);

        int twoSidesLeftSum = perimeter - maxSide;

        for (int i = twoSidesLeftSum; i > 0; i--) {
            int k = twoSidesLeftSum - i;
            if ((i * i) + (k * k) == maxSide * maxSide) {
                nums.add(k);
                nums.add(i);
                break;
            }
        }
        Collections.sort(nums);
        Collections.reverse(nums);
        for (int i : nums) {
            for (int k : nums) {
                for (int j : nums) {
                    if (i != k && k != j && i != j) {
                        System.out.printf("%d.%d.%d%n", i, k, j);
                    }
                }
            }
        }
    }
}
