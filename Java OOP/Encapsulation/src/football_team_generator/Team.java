package football_team_generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.setPlayers();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                this.players.remove(player);
                return;
            }
        }
        throw new IllegalArgumentException(
                String.format("Player %s is not in %s team.",
                        name, this.getName()));
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "A name should not be empty.");
        }
        this.name = name;
    }

    private void setPlayers() {
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        double rating = 0;
        for (Player player : this.players) {
            rating += player.overallSkillLevel();
        }
        rating /= this.players.size();

        return rating;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), Math.round(this.getRating()));

    }
}
