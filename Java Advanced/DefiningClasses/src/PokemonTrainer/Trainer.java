package PokemonTrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private Map<String, List<Pokemon>> pokemons = new HashMap<>();

    Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.set();
    }

    private void set() {
        this.pokemons.put("Fire", new ArrayList<>());
        this.pokemons.put("Water", new ArrayList<>());
        this.pokemons.put("Electricity", new ArrayList<>());
    }


    void add(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(),new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    void incrementBadges(int i) {
        this.numberOfBadges += i;
    }

    boolean hasPokemons(String element) {
        return !this.pokemons.get(element).isEmpty();
    }

    void damagePokemons() {
        for (List<Pokemon> value : this.pokemons.values()) {
            for (Pokemon pokemon : value) {
                pokemon.damageHealth(10);
            }
        }
        this.clearDeadPokemons();
    }

    private void clearDeadPokemons() {
        for (List<Pokemon> value : this.pokemons.values()) {
            value.removeIf(e -> e.getHealth() <= 0);
        }
    }

    @Override
    public String toString() {
        int numberOfPokemons = 0;
        for (List<Pokemon> value : this.pokemons.values()) {
            numberOfPokemons += value.size();
        }

        return String.format("%s %d %d", this.name,
                this.numberOfBadges, numberOfPokemons);
    }
}
