import java.util.*;
import java.util.stream.Collectors;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> people = new LinkedList<>();
        int capacity = 0;

        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> halls = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .forEach(queue::push);
        String hallName = "";
        boolean isFull = false;
        while (!queue.isEmpty()) {
            String val = queue.pop();
            if (isNumber(val)) {
                if(halls.size()>0) {
                    int peopleNumber = Integer.parseInt(val);
                    if (capacity + peopleNumber <= n) {
                        capacity += peopleNumber;
                        people.add(peopleNumber + "");
                    } else {
                        queue.push(peopleNumber + "");
                        System.out.printf("%s -> %s%n",
                                halls.poll(), String.join(", ", people));
                        capacity = 0;
                        people.clear();
                    }
                }
            } else {
                halls.offer(val);
            }
        }
    }

    static boolean isNumber(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
