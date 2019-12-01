package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Gun gun : mainPlayer.getGunRepository().getModels()) {
            for (Player civilPlayer : civilPlayers) {
                if (!gun.canFire()) {
                    break;
                }
                while (gun.canFire() && civilPlayer.isAlive()) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
            }

        }
        for (Player civilPlayer : civilPlayers) {
            if(civilPlayer.isAlive()) {
                for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                    if (!mainPlayer.isAlive()) {
                        break;
                    }
                    while (gun.canFire() && mainPlayer.isAlive()) {
                        mainPlayer.takeLifePoints(gun.fire());
                    }
                }
            }
        }
    }
}
