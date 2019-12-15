package aquarium.models.aquariums;

import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        decorations = new ArrayList<>();//FIXME
        fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        int result = 0;
        for (Decoration decoration : decorations) {
            result += decoration.getComfort();
        }

        return result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() + 1 <= capacity) {
            this.fish.add(fish);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish1 : fish) {
            fish1.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder res = new StringBuilder();

        res.append(this.getName() + " (" + getClass().getSimpleName() + "):").append(System.lineSeparator());
        res.append("Fish: ");
        if (this.getFish().isEmpty()) {
            res.append("none");
        } else {
            String fishStr = "";
            for (Fish fish : this.getFish()) {
                fishStr += (fish.getName() + " ");
            }
            res.append(fishStr.trim());
        }
        int comfort = 0;
        for (Decoration decoration : decorations) {
            comfort += decoration.getComfort();
        }


        res.append(System.lineSeparator());
        res.append("Decorations: "+ decorations.size() + System.lineSeparator());
        res.append("Comfort: "+ comfort);


        return res.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
