package person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String childName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Child child = new Child(childName, age);
        System.out.println(child.getName());
        System.out.println(child.getAge());
    }
}
