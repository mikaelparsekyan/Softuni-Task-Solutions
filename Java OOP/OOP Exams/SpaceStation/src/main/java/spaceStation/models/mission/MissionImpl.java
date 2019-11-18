package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String> itemsToRemove = new ArrayList<>();
        List<Astronaut> astronautsToRemove = new ArrayList<>();
        for (Astronaut astronaut : astronauts) {
            if (astronaut.canBreath()) {
                for (String item : planet.getItems()) {
                    astronaut.breath();
                    astronaut.getBag().getItems().add(item);
                    itemsToRemove.add(item);
                    if (!astronaut.canBreath()) {
                        astronautsToRemove.add(astronaut);//dead :((
                        break;
                    }
                }
                planet.getItems().removeAll(itemsToRemove);
            }
        }
        astronauts.removeAll(astronautsToRemove);

    }
}
