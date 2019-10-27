package strategyPattern;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> set1 = new TreeSet<>(new FirstPersonComparator());
        TreeSet<Person> set2 = new TreeSet<>(new SecondPersonComparator());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person p = new Person(input[0], Integer.parseInt(input[1]));
            set1.add(p);
            set2.add(p);
        }


        for (Person p1 : set1) {
            System.out.println(p1.toString());
        }
        for (Person p2 : set2) {
            System.out.println(p2.toString());
        }
    }
}
