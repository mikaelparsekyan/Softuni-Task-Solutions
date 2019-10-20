package custom_list_iterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!"END".equals(line)) {
            String[] elements = line.split("\\s+");
            String command = elements[0];
            switch (command) {
                case "Add":
                    customList.add(elements[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(elements[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(elements[1]));
                    break;
                case "Swap":
                    int i1 = Integer.parseInt(elements[1]);
                    int i2 = Integer.parseInt(elements[2]);
                    customList.swap(i1, i2);
                    break;
                case "Greater":
                    System.out.println(customList.countGraterThan(elements[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    customList.sort();
                    break;
                case "Print":
                    for (String s : customList) {
                        System.out.println(s);
                    }

                    break;
            }

            line = scanner.nextLine();
        }
    }
}
