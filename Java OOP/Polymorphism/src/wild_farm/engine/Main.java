package wild_farm.engine;

import wild_farm.abstracts.Animal;
import wild_farm.foods.Food;
import wild_farm.foods.Meat;
import wild_farm.foods.Vegetable;
import wild_farm.models.Mouse;
import wild_farm.models.Zebra;
import wild_farm.models.felimes.Cat;
import wild_farm.models.felimes.Tiger;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        List<Animal> animals = new LinkedList<>();
        List<Food> foods = new LinkedList<>();
        String[] animalData = reader.readLineAsArray("\\s+");

        while (!animalData[0].equals("End")) {
            Animal currentAnimal = getAnimal(animalData);
            if (currentAnimal != null) {
                String[] input = reader.readLineAsArray("\\s+");
                Food food = null;
                if (input[0].equals("Vegetable")) {
                    food = new Vegetable(Integer.parseInt(input[1]));
                } else if (input[0].equals("Meat")) {
                    food = new Meat(Integer.parseInt(input[1]));
                }
                currentAnimal.makeSound();
                if (food != null) {
                    foods.add(food);
                    try {
                        currentAnimal.eat(food);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                animals.add(currentAnimal);
            }
            animalData = reader.readLineAsArray("\\s+");
        }
        animals.forEach(System.out::println);

    }

    private static Animal getAnimal(String[] data) {
        Animal animal = null;
        switch (data[0]) {
            case "Tiger":
                animal = new Tiger(data[0],
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3]);
                break;
            case "Cat":
                animal = new Cat(data[0],
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3],
                        data[4]);
                break;
            case "Zebra":
                animal = new Zebra(data[0],
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3]);
                break;
            case "Mouse":
                animal = new Mouse(data[0],
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3]);
                break;
        }
        return animal;
    }
}
