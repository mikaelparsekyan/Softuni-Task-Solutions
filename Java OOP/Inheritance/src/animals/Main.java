package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"Beast!".equals(input)) {
            String[] objectArgs = scanner.nextLine().split("\\s+");

            Animal currentAnimal = getAnimal(input, objectArgs);
            if (currentAnimal != null) {
                printAnimal(currentAnimal);
            }
            input = scanner.nextLine();
        }
    }

    private static void printAnimal(Animal animal) {
        System.out.println(animal.toString());
    }

    private static Animal getAnimal(String type, String[] args) {
        String name = args[0];
        int age = Integer.parseInt(args[1]);
        String gender = args[2];

        Animal animal = null;
        try {
            switch (type) {
                case "Cat":
                    animal = new Cat(name, age, gender);
                    break;
                case "Dog":
                    animal = new Dog(name, age, gender);
                    break;
                case "Frog":
                    animal = new Frog(name, age, gender);
                    break;
                case "Kitten":
                    animal = new Kitten(name, age);
                    break;
                case "Tomcat":
                    animal = new Tomcat(name, age);
                    break;

                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }
}
