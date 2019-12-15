package aquarium.repositories;

import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {
        Decoration dec = null;
        switch (type) {
            case "Plant":
                dec = new Plant();
                break;
            case "Ornament":
                dec = new Ornament();
                break;
        }

        return dec;
    }
}
