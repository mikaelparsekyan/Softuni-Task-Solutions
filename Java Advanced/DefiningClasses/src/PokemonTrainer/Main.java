package PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!"Tournament".equals(input)) {
            String[] elements = input.split("\\s+");
            String trainerName = elements[0];
            String pokemonName = elements[1];
            String pokemonElement = elements[2];
            int pokemonHealth = Integer.parseInt(elements[3]);

            Trainer t = new Trainer(trainerName);

            Pokemon pokemon = new Pokemon(
                    pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, t);
            trainers.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            for (var trainer : trainers.values()) {
                if (trainer.hasPokemons(input)) {
                    trainer.incrementBadges(1);
                } else {
                    trainer.damagePokemons();
                }
            }
            input = scanner.nextLine();
        }
        trainers.values().stream().sorted((a, b) -> {
            return Integer.compare(b.getNumberOfBadges(),
                    a.getNumberOfBadges());
        }).forEach(e -> System.out.println(e.toString()));

    }
}
