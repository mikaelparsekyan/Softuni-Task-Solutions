package FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Person> name = new HashMap<>();
        Map<String,Person> date = new HashMap<>();
        while (!"End".equals(input)) {
            String[] elements = scanner.nextLine().split(" - ");
            String left = elements[0];
            String right = elements[1];
            if (!left.contains("/") && !right.contains("/")) {
                name.putIfAbsent(left,new Person());
                Person p = new Person();
                p.setName(left);
                name.get(left).getChild().add(p);
            } else if (!left.contains("/") && right.contains("/")) {
                name.putIfAbsent(left,new Person());
                Person p = new Person();
                p.setBirthday(left);
                name.get(left).getChild().add(p);
            } else if (left.contains("/") && !right.contains("/")) {
                date.putIfAbsent(left,new Person());
                Person p = new Person();
                p.setName(right);
                date.get(left).getChild().add(p);
            } else {

            }
            input = scanner.nextLine();
        }
    }
}
