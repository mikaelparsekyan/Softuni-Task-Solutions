package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Gun> guns;
    private Map<String, Player> civilPlayers;
    private Player mainPlayer;
    private Neighbourhood gangNeighbourhood;

    public ControllerImpl() {
        this.civilPlayers = new LinkedHashMap<>();
        this.guns = new GunRepository();
        this.mainPlayer = new MainPlayer();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.civilPlayers.put(name, new CivilPlayer(name));
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        if (type.equals("Pistol")) {
            guns.add(new Pistol(name));
        } else if (type.equals("Rifle")) {
            guns.add(new Rifle(name));
        } else {
            return ConstantMessages.GUN_TYPE_INVALID;
        }
        return String.format(ConstantMessages.GUN_ADDED, name, type);

    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.getModels().isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = this.guns.getModels().stream().findFirst().get();
        if (name.equals("Vercetti")) {
            this.guns.remove(gun);
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER,
                    gun.getName(), mainPlayer.getName());
        } else {
            Player player = civilPlayers.get(name);
            if (player != null) {
                player.getGunRepository().add(gun);
                this.guns.remove(gun);
                return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,
                        gun.getName(), name);
            }
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
    }

    @Override
    public String fight() {
        gangNeighbourhood.action(mainPlayer, new ArrayList<>(civilPlayers.values()));

        List<Player> deadPlayers = civilPlayers.values()
                .stream()
                .filter(p -> p.getLifePoints() <= 0)
                .collect(Collectors.toList());

        civilPlayers.values().removeAll(deadPlayers);

        List<Gun> gunsToRemove = guns.getModels().stream().filter(e -> !e.canFire())
                .collect(Collectors.toList());

        for (Gun gun : gunsToRemove) {
            guns.getModels().remove(gun);
        }
        List<Player> harmedPeople = civilPlayers.values().stream().filter(p -> p.getLifePoints() < 50).collect(Collectors.toList());

        if (mainPlayer.getLifePoints() == 100 &&
                harmedPeople.size() == 0) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            String fightResult = ConstantMessages.FIGHT_HAPPENED + System.lineSeparator() + String.format(
                    ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()) +
                    System.lineSeparator() +
                    String.format(
                            ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()) +
                    System.lineSeparator() +
                    String.format(
                            ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size()) +
                    System.lineSeparator();
            return fightResult;
        }
    }
}
