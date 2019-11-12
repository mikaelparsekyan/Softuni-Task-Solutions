package collection_hierarchy;

import collection_hierarchy.collections.AddCollection;
import collection_hierarchy.collections.AddRemoveCollection;
import collection_hierarchy.collections.MyListImpl;
import collection_hierarchy.models.Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine()
                .split("\\s+");

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl list = new MyListImpl();

        int operations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input.length; i++) {
            System.out.print(addCollection.add(input[i]) + " ");
        }
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(addRemoveCollection.add(input[i]) + " ");
        }
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(list.add(input[i]) + " ");
        }
        System.out.println();
        for (int i = 0; i < operations; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        for (int i = 0; i < operations; i++) {
            System.out.print(list.remove() + " ");
        }
    }
}
