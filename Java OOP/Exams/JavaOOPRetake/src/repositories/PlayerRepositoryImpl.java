package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (players.contains(player)) {
            throw new IllegalArgumentException(String.format("Player %s already exists!",
                    player.getUsername()));
        }
        players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        return players.remove(player);
    }

    @Override
    public Player find(String name) {
        for (Player player : players) {
            if (player.getUsername().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
