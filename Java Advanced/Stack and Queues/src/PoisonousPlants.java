import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
        Object lastVal = new ArrayList<>().clone();
        while (stack.peek()!=lastVal) {
            lastVal = plants;
            for (int i = 1; i < plants.size(); i++) {
                int currentPlant = plants.get(i);
                int leftPlant = plants.get(i - 1);
                if (currentPlant > leftPlant) {
                    plants.remove(i);
                }
            }
            stack.push(plants);
        }
//        for (Integer i : plants) {
//            System.out.print(i + " ");
//        }
        System.out.println(stack.size());
        System.out.println();
    }
}
