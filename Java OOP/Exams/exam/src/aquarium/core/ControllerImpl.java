package aquarium.core;

import aquarium.models.aquariums.Aquarium;
import aquarium.models.aquariums.FreshwaterAquarium;
import aquarium.models.aquariums.SaltwaterAquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;
import aquarium.models.fish.Fish;
import aquarium.models.fish.FreshwaterFish;
import aquarium.models.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
        }
        if (aquarium == null) {
            throw new IllegalArgumentException(INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
        }
        if (decoration == null) {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium aquarium = null;
        for (Aquarium a : aquariums) {
            if (a.getName().equals(aquariumName)) {
                aquarium = a;
            }
        }

        Decoration dec = decorations.findByType(decorationType);

        if (dec != null) {
            aquarium.addDecoration(dec);
            decorations.remove(dec);
        } else {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = null;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
        }
        if (fish == null) {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        Aquarium aquarium = null;
        for (Aquarium a : aquariums) {
            if (a.getName().equals(aquariumName)) {
                aquarium = a;
            }
        }
        if (aquarium != null) {
            aquarium.addFish(fish);
        }

        if (!(fish instanceof SaltwaterFish && aquarium instanceof SaltwaterAquarium)) {
            return WATER_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium a : aquariums) {
            if (a.getName().equals(aquariumName)) {
                aquarium = a;
            }
        }
        if (aquarium != null) {
            aquarium.feed();
        }
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium a : aquariums) {
            if (a.getName().equals(aquariumName)) {
                aquarium = a;
            }
        }
        double sum = 0;
        if (aquarium != null) {
            for (Fish fish : aquarium.getFish()) {
                sum += fish.getPrice();
            }
            for (Decoration decoration : aquarium.getDecorations()) {
                sum += decoration.getPrice();
            }
        }
        return String.format(VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder res = new StringBuilder();

        for (Aquarium aquarium : aquariums) {
            res.append(aquarium.getInfo() + System.lineSeparator());
        }

        return res.toString().trim();
    }
}
